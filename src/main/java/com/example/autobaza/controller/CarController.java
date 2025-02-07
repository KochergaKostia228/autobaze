package com.example.autobaza.controller;

import com.example.autobaza.DTO.CarDTO;
import com.example.autobaza.service.carservice.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller()
public class CarController {

    @Autowired
    CarServiceImpl carService;

    @GetMapping(value = "/cars/get")
    public String getCars(Model model){
        model.addAttribute("cars", carService.findAll());
        return "cars";
    }

    @PostMapping(value = "/car/create")
    public String createEvent(@ModelAttribute CarDTO carDTO)
    {
        carService.createCar(carDTO);
        return "redirect:/cars/get";
    }

    @GetMapping(value = "/createCarPage")
    public String createEventPage(Model model) {
        model.addAttribute("carDTO", new CarDTO());
        return "createCarPage";
    }
}
