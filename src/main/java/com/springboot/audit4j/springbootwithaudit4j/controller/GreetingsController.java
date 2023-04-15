package com.springboot.audit4j.springbootwithaudit4j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.audit4j.springbootwithaudit4j.services.GreetingsService;

@RestController
public class GreetingsController {
    
    @Autowired
    private GreetingsService service;

    @GetMapping(value = {"/", "/welcome"}, produces = "application/json")
    public String welcome() {
        String name = "anonymous";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            name= ((UserDetails) authentication.getPrincipal()).getUsername();
        }
        return service.greet(name);
    }
}
