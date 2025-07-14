package com.academicchimes.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academicchimes.app.models.User;
import com.academicchimes.app.services.UserAuthService;



@RestController
@RequestMapping("/api")
public class AuthController {
    
    @Autowired
    UserAuthService userAuthService;

    @GetMapping("/")
    public String apiStatus() {
        return "Backend API is live";
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> loginAuth(@RequestBody User loginRequest) {
        return ResponseEntity.ok(userAuthService.loginUser(loginRequest));
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> registerAuth(@RequestBody User registerRequest) { 
        if(!userAuthService.userAlreadyExists(registerRequest))
            return ResponseEntity.ok(userAuthService.saveUser(registerRequest));
        return ResponseEntity.status(401).body("User is already registered");
    }
}
