package com.example.user_service.dto;

import java.time.LocalDate;

public record UserUpdateRequest(
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
