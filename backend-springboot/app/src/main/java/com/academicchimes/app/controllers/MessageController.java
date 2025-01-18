package com.academicchimes.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.academicchimes.app.models.Message;


@Controller
@RequestMapping("/api/chat")
public class MessageController {

    @MessageMapping("/private")
    public ResponseEntity<?> sendPrivateMessage(Message message){
        return ResponseEntity.ok().body("message sent");
    }
    
}
   