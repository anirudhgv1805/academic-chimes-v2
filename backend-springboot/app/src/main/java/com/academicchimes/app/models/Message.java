package com.academicchimes.app.models;

import java.time.Instant;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn
    private User sender;

    @ManyToOne
    @JoinColumn
    private User recipient;

    private String status;
    
    private Instant createdAt;
    // private boolean isDeleted;
    private MessageType messageType;
    
}
