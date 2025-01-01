package com.academicchimes.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academicchimes.app.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByUserId(String userId);

    Boolean existsByUserId(String userId);
}