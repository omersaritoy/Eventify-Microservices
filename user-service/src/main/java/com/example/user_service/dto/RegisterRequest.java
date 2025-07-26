package com.example.user_service.dto;

import com.example.user_service.model.Role;

public record RegisterRequest(
        String email,
        String username,
        String password,
        String firstname,
        String lastname,
        String role
) {
}
