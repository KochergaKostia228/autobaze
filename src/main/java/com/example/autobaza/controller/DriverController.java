package com.example.autobaza.controller;

import com.example.autobaza.DTO.CarDTO;
import com.example.autobaza.DTO.DriverDTO;
import com.example.autobaza.service.carservice.CarServiceImpl;
import com.example.autobaza.service.driverservice.DriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("")
public class DriverController {
    @Autowired
    DriverServiceImpl driverService;

//    @GetMapping(value = "/drivers/get")
//    public String getDrivers(Model model){
//        model.addAttribute("drivers", driverService.findAll());
//        return "drivers";
//    }
//
//    @PostMapping(value = "/driver/create")
//    public String createDriver(@ModelAttribute DriverDTO driverDTO)
//    {
//        driverService.createDriver(driverDTO);
//        return "redirect:/drivers/get";
//    }
//
//    @GetMapping(value = "/createDriverPage")
//    public String createDriverPage(Model model) {
//        model.addAttribute("driverDTO", new DriverDTO());
//        return "createDriver";
//    }
}
