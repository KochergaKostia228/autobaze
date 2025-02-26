package com.example.autobaza.controller;

import com.example.autobaza.DTO.CarDTO;
import com.example.autobaza.service.carservice.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Collection;

@Controller()
public class CarController {

    @Autowired
    CarServiceImpl carService;

    @GetMapping(value = "/cars/get")
    public String getCars(Model model, Principal principal){
        model.addAttribute("cars", carService.findAll());

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();
        StringBuilder roles = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            roles.append(authority.getAuthority());
        }

        model.addAttribute("roles", roles.toString());

        return "cars";
    }

    @PostMapping(value = "/car/create")
    public String createCar(@ModelAttribute CarDTO carDTO)
    {
        carService.createCar(carDTO);
        return "redirect:/cars/get";
    }

    @GetMapping(value = "/createCarPage")
    public String createCarPage(Model model, Principal principal) {
        model.addAttribute("carDTO", new CarDTO());

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();
        StringBuilder roles = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            roles.append(authority.getAuthority());
        }

        model.addAttribute("roles", roles.toString());

        return "createCarPage";
    }
}
