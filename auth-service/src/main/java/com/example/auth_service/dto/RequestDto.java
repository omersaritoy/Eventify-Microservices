package com.example.auth_service.dto;

public record RequestDto(
        String name,
        String email,
        String username,
        String password
) {

}
