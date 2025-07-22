package com.academicchimes.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academicchimes.app.configurations.Authenticator;
import com.academicchimes.app.security.JwtUtil;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private Authenticator authenticator;
    @Autowired
    private JwtUtil jwtUtil;


    @GetMapping("/chatList")
    public ResponseEntity<?> fetchAllMessages(@RequestHeader("Authorization") String authorizationHeader){
        String token = authenticator.verifyTheAuthentication(authorizationHeader);
        String userId = jwtUtil.extractUserName(token);
        
        return ResponseEntity.ok().body("All messages are fetched" + userId);
    }

}
