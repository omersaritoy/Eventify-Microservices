package com.example.auth_service.dto;

import java.time.LocalDate;

public record UserRequest(
        String email,
        String username,
        String password,
        String firstName,
        String lastName,
        String phone,
        String profileImageUrl,
        String bio,
        LocalDate dateOfBirth,
        String gender,
        String location,
        String role
) {}
