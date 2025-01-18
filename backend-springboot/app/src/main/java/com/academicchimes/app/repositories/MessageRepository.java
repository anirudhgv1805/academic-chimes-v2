package com.academicchimes.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academicchimes.app.models.Message;

public interface MessageRepository extends JpaRepository<Message,Long>{

    
}
