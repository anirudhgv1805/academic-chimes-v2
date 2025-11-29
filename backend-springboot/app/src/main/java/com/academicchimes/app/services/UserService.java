package com.academicchimes.app.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academicchimes.app.dto.UserDTO;
import com.academicchimes.app.models.User;
import com.academicchimes.app.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDTO fetchUserProfile(String userId){
        UserDTO userDTO = new UserDTO(userRepository.findByUserId(userId).get());
        return userDTO;
    }

    public Set<User> fetchContactList(String userId){
        User user = userRepository.findByUserId(userId).get();
        return user.getContacts();
    }

    public String addContact(String userId, String contactId){
        User user = userRepository.findByUserId(userId).get();
        User contact = userRepository.findByUserId(contactId).get();

        // if(user.getContacts() == null){
        //     user.setContacts(new HashSet<>());
        // }
        // if(contact.getContacts() == null){
        //     contact.setContacts(new HashSet<>());
        // }

        user.getContacts().add(contact);
        contact.getContacts().add(user);  

        userRepository.save(user);
        userRepository.save(contact);

        return "Contact Added Successfully";
    }
}
