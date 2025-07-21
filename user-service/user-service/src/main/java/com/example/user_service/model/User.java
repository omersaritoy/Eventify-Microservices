package com.example.user_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique=true)
    @Email
    private String email;

    @Column(unique=true)
    private String username;

    private String passwordHash;

    private String firstName;

    private String lastName;

    private String phone;
    private String profileImageUrl;
    private String bio;
    private LocalDate dateOfBirth;
    private String gender;
    private String location;
    private Boolean isVerified = false;
    private Boolean isActive = true;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;




}
