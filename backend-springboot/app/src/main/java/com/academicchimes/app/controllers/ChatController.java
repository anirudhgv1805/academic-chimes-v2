package com.academicchimes.app.controllers;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academicchimes.app.configurations.Authenticator;
import com.academicchimes.app.models.User;
import com.academicchimes.app.security.JwtUtil;
import com.academicchimes.app.services.UserService;


@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private Authenticator authenticator;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService userService;


    @GetMapping("/contactList")
    public ResponseEntity<?> fetchAllContacts(@RequestHeader("Authorization") String authorizationHeader){
        String token = authenticator.verifyTheAuthentication(authorizationHeader);
        String userId = jwtUtil.extractUserName(token);

        Set<User> contactList = userService.fetchContactList(userId);
        
        return ResponseEntity.status(HttpStatus.OK).body(contactList);
    }

    @PostMapping("/addContact")
    public ResponseEntity<?> addContact(@RequestHeader("Authorization") String authorizationHeader,@RequestBody Map<String,String> contact) {
        String token = authenticator.verifyTheAuthentication(authorizationHeader);
        String userId = jwtUtil.extractUserName(token);

        System.out.println("This is the contactId "+ contact.toString());
        return ResponseEntity.ok().body(userService.addContact(userId, "summa`"));
    }
    

}
