package com.academicchimes.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academicchimes.app.dto.UserDTO;
import com.academicchimes.app.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDTO fetchUserProfile(String userId){
        UserDTO userDTO = new UserDTO(userRepository.findByUserId(userId).get());
        return userDTO;
    }

    
    public String example(){
        return new String("Hello World!!");
    }
}
