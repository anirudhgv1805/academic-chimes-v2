package com.academicchimes.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academicchimes.app.dto.UserDTO;
import com.academicchimes.app.security.JwtUtil;
import com.academicchimes.app.services.UserService;


@RestController
@RequestMapping("/api/account")
public class UserProfileController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/me")
    public UserDTO giveProfile(@RequestBody String token) {
        String userId = jwtUtil.extractUserName(token);
        return userService.fetchUserProfile(userId);
    }
    
}
