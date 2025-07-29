package com.example.auth_service.dto;

import jakarta.validation.constraints.Email;

public record RegisterRequest(
        String firstname,
        String lastname,
        @Email
        String email,
        String username,
        String password,
        Role role
) {
}

