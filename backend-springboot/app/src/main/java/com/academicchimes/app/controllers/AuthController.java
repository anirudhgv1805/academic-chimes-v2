package com.academicchimes.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academicchimes.app.dto.LoginRequest;
import com.academicchimes.app.dto.RegisterRequest;
import com.academicchimes.app.services.UserService;



@RestController
@RequestMapping("/api")
public class AuthController {
    
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String apiStatus() {
        return new String("Backend API is live");
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> loginAuth(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.loginUser(loginRequest));
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> registerAuth(@RequestBody RegisterRequest registerRequest) { 
        return ResponseEntity.ok(userService.saveUser(registerRequest));
    }
}
