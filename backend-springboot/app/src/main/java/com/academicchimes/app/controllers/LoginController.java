package com.academicchimes.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class LoginController {
    
    @GetMapping("/")
    public String apiStatus() {
        return new String("API is live");
    }
}
