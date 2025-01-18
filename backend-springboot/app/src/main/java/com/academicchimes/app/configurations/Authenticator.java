package com.academicchimes.app.configurations;

import org.springframework.stereotype.Service;

@Service
public class Authenticator {
    
    public String verifyTheAuthentication(String authorizationHeader) {
        String token = new String();
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer")){
            token = authorizationHeader.substring(7);
        }
        return token;
    }
}
