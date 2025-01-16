package com.academicchimes.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.academicchimes.app.models.User;
import com.academicchimes.app.repositories.UserRepository;
import com.academicchimes.app.security.JwtUtil;

@Service
public class UserAuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<?> saveUser(User registerRequest){
        User user = registerRequest;
        if(userRepository.existsByUserId(user.getUserId()))
            return ResponseEntity.status(409).body("User already registered");
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        return ResponseEntity.ok(userRepository.save(user));
    }

    public ResponseEntity<String> loginUser(User loginRequest) {
        if(!userRepository.findByUserId(loginRequest.getUserId()).isPresent()) 
            return ResponseEntity.status(401).body("User is not registered");
        if(verifyCredentials(loginRequest)){
            User user = userRepository.findByUserId(loginRequest.getUserId()).get();
            String token = jwtUtil.generateToken(user.getUserId(), user.getRole());
            return ResponseEntity.ok().body(token);
        }
        else 
            return ResponseEntity.status(401).body("Password is incorrect");
    }

    private Boolean verifyCredentials(User loginRequest){
        return passwordEncoder.matches(loginRequest.getPassword(),userRepository.findByUserId(loginRequest.getUserId()).get().getPassword());
    }
}
