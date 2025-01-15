package com.academicchimes.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academicchimes.app.models.User;
import com.academicchimes.app.services.UserAuthService;



@RestController
@RequestMapping("/api")
@CrossOrigin("${cors.allowedOrigins}")
public class AuthController {
    
    @Autowired
    UserAuthService userAuthService;

    @GetMapping("/")
    public String apiStatus() {
        return new String("Backend API is live");
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> loginAuth(@RequestBody User loginRequest) {

        System.out.println(loginRequest);
        return ResponseEntity.ok(userAuthService.loginUser(loginRequest));
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> registerAuth(@RequestBody User registerRequest) { 
        System.out.println(registerRequest);
        return ResponseEntity.ok(userAuthService.saveUser(registerRequest));
    }
}
