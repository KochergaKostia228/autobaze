package com.example.autobaza.controller;

import com.example.autobaza.DTO.RequestDTO;
import com.example.autobaza.service.requestservice.RequestService;
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

@Controller
public class TrimController {
//    @Autowired
//    TrimSer requestService;
//
//    @GetMapping(value = "/requests/get")
//    public String getCars(Model model, Principal principal){
//        model.addAttribute("requests", requestService.findAll());
//
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();
//        StringBuilder roles = new StringBuilder();
//        for (GrantedAuthority authority : authorities) {
//            roles.append(authority.getAuthority());
//        }
//
//        model.addAttribute("roles", roles.toString());
//
//        return "requests";
//    }
//
//    @PostMapping(value = "/request/create")
//    public String createEvent(@ModelAttribute RequestDTO requestDTO)
//    {
//        requestService.createRequest(requestDTO);
//        return "redirect:/requests/get";
//    }
//
//    @GetMapping(value = "/createRequestPage")
//    public String createEventPage(Model model, Principal principal) {
//        model.addAttribute("requestDTO", new RequestDTO());
//
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();
//        StringBuilder roles = new StringBuilder();
//        for (GrantedAuthority authority : authorities) {
//            roles.append(authority.getAuthority());
//        }
//
//        model.addAttribute("roles", roles.toString());
//
//        return "createRequestPage";
//    }
}
