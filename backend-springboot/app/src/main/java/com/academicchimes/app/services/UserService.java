package com.academicchimes.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.academicchimes.app.dto.LoginRequest;
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
        if(userRepository.existsByUserId(user.getUserId()))
            return ResponseEntity.status(409).body("User already registered");
        return ResponseEntity.ok(userRepository.save(user));
    }

    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {
        if(!userRepository.findByUserId(loginRequest.getUserId()).isPresent()) 
            return ResponseEntity.status(401).body("Username is wrong or not yet registered");
        if(verifyCredentials(loginRequest))
            return ResponseEntity.ok("User login successfully verified");
        else 
            return ResponseEntity.status(401).body("The password u entered is wrong");
    }

    private User setRegistration(RegisterRequest registerRequest) {
        User user = new User();
        user.setUserId(registerRequest.getUserId());
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setDept(registerRequest.getDept());
        user.setBatch(registerRequest.getBatch());
        user.setRole(registerRequest.getRole());
        user.setSection(registerRequest.getSection());
        return user;
    }

    private Boolean verifyCredentials(LoginRequest loginRequest){
        User user = userRepository.findByUserId(loginRequest.getUserId()).get();
        if(passwordEncoder.matches(loginRequest.getPassword(),user.getPassword()))
            return true;
        else
            return false;
    }
}
