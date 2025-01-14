package com.academicchimes.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.headers.HeadersSecurityMarker;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academicchimes.app.dto.UserDTO;
import com.academicchimes.app.security.JwtUtil;
import com.academicchimes.app.services.UserService;


@RestController
@RequestMapping("/api")
@CrossOrigin("${cors.allowedOrigins}")
public class UserProfileController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/me")
    public UserDTO giveProfile(@RequestHeader("Authorization") String authorizationHeader) {
        System.out.println("This is the acutal request"+authorizationHeader);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            String token = authorizationHeader.substring(7);
            System.out.println(token);
            String userId = jwtUtil.extractUserName(token);
            return userService.fetchUserProfile(userId);
        }
        else{
            throw new IllegalArgumentException("Invalid Authorization header is passed");
        }
    }
    
}
