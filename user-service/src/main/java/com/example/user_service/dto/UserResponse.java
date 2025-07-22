package com.example.user_service.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String email,
        String username,
        String firstName,
        String lastName,
        String phone,
        String profileImageUrl,
        String bio,
        LocalDate dateOfBirth,
        String gender,
        String location,
        Boolean isVerified,
        Boolean isActive,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}