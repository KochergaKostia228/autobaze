package com.example.autobaza.controller;

import com.example.autobaza.DTO.RepairRequestDTO;
import com.example.autobaza.model.RepairRequest;
import com.example.autobaza.model.Trip;
import com.example.autobaza.service.carservice.CarServiceImpl;
import com.example.autobaza.service.repairrequestservice.RepairRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;

@Controller
public class RepairRequestController {
    @Autowired
    RepairRequestService repairRequestService;

    @Autowired
    CarServiceImpl carService;

    @GetMapping(value = "/repairRequests/get")
    public String getRepairRequests(Model model, Principal principal){
        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();

        StringBuilder roles = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            roles.append(authority.getAuthority());
        }

        model.addAttribute("roles", roles.toString());

        model.addAttribute("repairRequests", repairRequestService.findAll());

        return "repairRequests";
    }

    @PostMapping(value = "/repairRequest/complete/{id}")
    public String cancelRepairRequests(@PathVariable("id") Long id)
    {
        RepairRequest repairRequest = repairRequestService.findById(id);

        carService.updateCarBroken(repairRequest.getCar().getId(), false);

        return "redirect:/repairRequests/get";
    }

    @PostMapping(value = "/repairRequest/create/{id}")
    public String createCar(@RequestParam String description, @PathVariable("id") Long id)
    {
        RepairRequestDTO repairRequestDTO = new RepairRequestDTO();
        repairRequestDTO.setCar_id(id);
        repairRequestDTO.setDescription(description);

        repairRequestService.createRequest(repairRequestDTO);
        return "redirect:/trips/get";
    }

    @GetMapping(value = "/createRepairRequestPage/{id}")
    public String createCarPage(Model model, Principal principal, @PathVariable("id") Long id) {
        model.addAttribute("car", carService.findById(id));

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();
        StringBuilder roles = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            roles.append(authority.getAuthority());
        }

        model.addAttribute("roles", roles.toString());

        return "createRepairRequestPage";
    }
}
