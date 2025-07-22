package com.example.auth_service.dto;

public record AuthRequest(
        String email,
        String password
) {}
