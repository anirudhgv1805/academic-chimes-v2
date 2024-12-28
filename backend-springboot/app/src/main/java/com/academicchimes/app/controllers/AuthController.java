package com.academicchimes.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academicchimes.app.dto.LoginRequest;

import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api")
public class AuthController {
    
    @GetMapping("/")
    public String apiStatus() {
        return new String("Backend API is live");
    }

    @GetMapping("/auth/login")
    public ResponseEntity<?> loginAuth(@RequestBody LoginRequest loginRequest) {
        
        return ResponseEntity.ok("got the login request");
    }

    @GetMapping("/auth/register")
    public ResponseEntity<?> registerAuth() {
        return ResponseEntity.ok("register path is working");
    }
    
    
    
}
