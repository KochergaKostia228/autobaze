package com.example.autobaza.controller;

import com.example.autobaza.DTO.CarDTO;
import com.example.autobaza.DTO.RepairRequestDTO;
import com.example.autobaza.DTO.TripDTO;
import com.example.autobaza.model.RepairRequest;
import com.example.autobaza.model.Trip;
import com.example.autobaza.service.carservice.CarServiceImpl;
import com.example.autobaza.service.driverservice.DriverServiceImpl;
import com.example.autobaza.service.repairrequestservice.RepairRequestService;
import com.example.autobaza.service.requestservice.RequestService;
import com.example.autobaza.service.tripservice.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

@Controller
public class TripController {
    @Autowired
    TripService tripService;

    @Autowired
    CarServiceImpl carService;

    @Autowired
    DriverServiceImpl driverService;

    @Autowired
    RequestService requestService;

    public void updateTripStatus(){
        // Устанавливаем часовой пояс для Киева
        ZoneId kievZone = ZoneId.of("Europe/Kiev");

        // Получаем текущее время в Киевском часовом поясе
        ZonedDateTime kievTime = ZonedDateTime.now(kievZone);

        LocalDateTime localDateTime = kievTime.toLocalDateTime();

        List<Trip> tripList = tripService.findAll();

        for (var trip : tripList){
            if(trip.getTripDate().isBefore(localDateTime)){
                tripService.updateTripByStatus(trip.getId(), "В дорозі");
            }
        }
    }

    @GetMapping(value = "/trips/get")
    public String getTrips(Model model, Principal principal){
        updateTripStatus();

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();

        boolean isDriver = authorities.stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_DRIVER"));

        StringBuilder roles = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            roles.append(authority.getAuthority());
        }

        model.addAttribute("roles", roles.toString());

        if(isDriver){
            model.addAttribute("trips", tripService.findAllByDriverId(driverService.findByName(loginedUser.getUsername()).getId()));
        }
        else{
            model.addAttribute("trips", tripService.findAll());
        }

        return "trips";
    }

    @PostMapping(value = "/trip/create")
    public String createTrip(@ModelAttribute TripDTO tripDTO)
    {
        tripService.createTrip(tripDTO);
        return "redirect:/trips/get";
    }

    @PostMapping(value = "/trip/cancel/{id}")
    public String cancelTrip(@PathVariable("id") Long id)
    {
        Trip trip = tripService.findById(id);

        carService.updateCarCurrentLoad(trip.getCar().getId(), 0);

        tripService.deleteById(trip.getId());

        return "redirect:/trips/get";
    }

    @PostMapping(value = "/trip/complete/{id}")
    public String completeTrip(@PathVariable("id") Long id)
    {
        Trip trip = tripService.findById(id);

        carService.updateCarCurrentLoad(trip.getCar().getId(), 0);

        driverService.updateEarnings(trip.getDriver().getId(), trip.getEarnings());

        tripService.deleteById(trip.getId());

        requestService.deleteById(trip.getRequest().getId());

        return "redirect:/trips/get";
    }

    @GetMapping(value = "/createTripPage")
    public String createTripPage(Model model, Principal principal) {
        model.addAttribute("tripDTO", new TripDTO());
        model.addAttribute("cars", carService.findAll());
        model.addAttribute("drivers", driverService.findAll());
        model.addAttribute("requests", requestService.findAll());

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();
        StringBuilder roles = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            roles.append(authority.getAuthority());
        }

        model.addAttribute("roles", roles.toString());

        return "createTripPage";
    }
}
