package com.example.autobaza.controller;

import com.example.autobaza.DTO.CarDTO;
import com.example.autobaza.DTO.DriverDTO;
import com.example.autobaza.service.carservice.CarServiceImpl;
import com.example.autobaza.service.driverservice.DriverServiceImpl;
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
public class DriverController {
    @Autowired
    DriverServiceImpl driverService;

    @GetMapping(value = "/drivers/get")
    public String getDrivers(Model model, Principal principal){
        model.addAttribute("drivers", driverService.findAll());

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();
        StringBuilder roles = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            roles.append(authority.getAuthority());
        }

        model.addAttribute("roles", roles.toString());

        return "drivers";
    }
}
