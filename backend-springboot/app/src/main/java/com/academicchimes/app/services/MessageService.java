package com.academicchimes.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academicchimes.app.models.Message;
import com.academicchimes.app.repositories.MessageRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message saveMessage(Message message){
        return messageRepository.save(message);
    }

    // public List<Message> fetchAllMessages(String userId){

    // }
}
