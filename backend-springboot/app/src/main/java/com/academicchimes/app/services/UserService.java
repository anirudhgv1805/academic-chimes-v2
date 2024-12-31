package com.academicchimes.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.academicchimes.app.dto.RegisterRequest;
import com.academicchimes.app.models.User;
import com.academicchimes.app.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<?> saveUser(RegisterRequest registerRequest){
        User user = setRegistration(registerRequest);
        return ResponseEntity.ok(userRepository.save(user));
    }

    private User setRegistration(RegisterRequest registerRequest) {
        User user = new User();
        user.setId(registerRequest.getId());
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setDept(registerRequest.getDept());
        user.setBatch(registerRequest.getBatch());
        user.setRole(registerRequest.getRole());
        user.setSection(registerRequest.getSection());
        return user;
    }
}
