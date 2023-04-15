package com.springboot.audit4j.springbootwithaudit4j.services;

import org.audit4j.core.annotation.Audit;
import org.audit4j.core.annotation.AuditField;
import org.springframework.stereotype.Service;

@Service
public class GreetingsService {
    @Audit( action = "GreetingsService.greet" ) 
    public String greet(@AuditField(field = "loggedInUsername") String username) {
        return "Welcome "  + username;
    }
}
