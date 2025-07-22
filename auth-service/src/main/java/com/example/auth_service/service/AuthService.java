package com.example.auth_service.service;

import com.example.auth_service.client.UserClient;
import com.example.auth_service.dto.AuthResponse;
import com.example.auth_service.dto.UserRequest;
import com.example.auth_service.dto.UserResponse;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final JwtService jwtService;
    private final UserClient userClient;
    public AuthService(JwtService jwtService, UserClient userClient) {
        this.jwtService = jwtService;
        this.userClient = userClient;
    }
    public AuthResponse register(UserRequest userRequest) {
        userClient.register(userRequest);
        String token= jwtService.generateToken(userRequest.email());
        String refreshToken = jwtService.generateRefreshToken(userRequest.email());
        return new AuthResponse(token,refreshToken);
    }
}
