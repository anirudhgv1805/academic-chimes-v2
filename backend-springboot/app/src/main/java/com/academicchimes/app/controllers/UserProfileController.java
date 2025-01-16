package com.academicchimes.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academicchimes.app.dto.UserDTO;
import com.academicchimes.app.security.JwtUtil;
import com.academicchimes.app.services.UserService;


@RestController
@RequestMapping("/api")
public class UserProfileController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/me")
    public UserDTO giveProfile(@RequestHeader("Authorization") String authorizationHeader) {
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            String token = authorizationHeader.substring(7);
            String userId = jwtUtil.extractUserName(token);
            return userService.fetchUserProfile(userId);
        }
        else{
            throw new IllegalArgumentException("Invalid Authorization header is passed");
        }
    }
    
}
