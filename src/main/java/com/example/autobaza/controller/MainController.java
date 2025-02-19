package com.example.autobaza.controller;

import com.example.autobaza.DTO.DriverDTO;
import com.example.autobaza.model.AppUser;
import com.example.autobaza.model.Driver;
import com.example.autobaza.model.Role;
import com.example.autobaza.model.UserRole;
import com.example.autobaza.service.appuserservice.AppUserService;
import com.example.autobaza.service.driverservice.DriverService;
import com.example.autobaza.service.roleservice.RoleService;
import com.example.autobaza.service.userroleservice.UserRoleService;
import com.example.autobaza.utils.WebUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Collection;

@Controller
public class MainController {

    @Autowired
    private AppUserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private DriverService driverService;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping(value = {"/", "/welcome"})
    public String welcomePage(Model model) {
        return "loginPage";
    }

    @GetMapping(value = "/admin")
    public String adminPage(Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtil.pageInfoOutputMessageCreator(loginedUser);
        model.addAttribute("userInfo", userInfo);

        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();
        StringBuilder roles = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            roles.append(authority.getAuthority());
        }

        model.addAttribute("roles", roles.toString());

        return "adminPage";
    }

    @GetMapping(value = "/login")
    public String loginPage(Model model, @RequestParam(value = "error", required = false) String error) {
        model.addAttribute("error", error);
        return "loginPage";
    }

    @GetMapping(value = "/main")
    public String mainPage(Model model) {
        return "main";
    }

    @GetMapping(value = "/register")
    public String registerPage(Model model) {
        return "registerPage";
    }

    @PostMapping(value = "/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String confirmPassword,
                               Model model) {

        if (email == null || password == null || confirmPassword == null ||
                email.isEmpty() || password.isEmpty()) {
            model.addAttribute("error", "All fields are required.");
            return "registerPage";
        }

        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match.");
            return "registerPage";
        }

        if (userService.existsByUsername(username)) {
            model.addAttribute("error", "Username already exists.");
            return "registerPage";
        }

        AppUser newUser = new AppUser();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setEncrytedPassword(passwordEncoder.encode(password));
        newUser.setEnabled(true);

        userService.save(newUser);

        DriverDTO driverDTO = new DriverDTO();
        driverDTO.setName(newUser.getUsername());
        driverDTO.setEmail(newUser.getEmail());
        driverDTO.setExperience(1);

        driverService.createDriver(driverDTO);

        Role userRole = roleService.findByRoleName("USER");

        if (userRole == null) {
            userRole = new Role();
            userRole.setRoleName("USER");
            roleService.save(userRole);
        }

        UserRole userRoleMapping = new UserRole();
        userRoleMapping.setAppUser(newUser);
        userRoleMapping.setRole(userRole);
        userRoleService.save(userRoleMapping);

        model.addAttribute("success", "Registration successful!");
        return "redirect:/login";
    }

    @GetMapping(value = "/userInfo")
    public String userInfo(Model model, Principal principal) {

        String userName = principal.getName();

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtil.pageInfoOutputMessageCreator(loginedUser);
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("userName", userName);

        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();
        StringBuilder roles = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            roles.append(authority.getAuthority());
        }

        model.addAttribute("roles", roles.toString());

        return "userInfoPage";
    }
}
