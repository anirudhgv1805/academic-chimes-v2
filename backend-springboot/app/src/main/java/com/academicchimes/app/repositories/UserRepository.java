package com.academicchimes.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academicchimes.app.models.User;

public interface UserRepository extends JpaRepository<User, String> {
    
    public User findUserById(String id);
}