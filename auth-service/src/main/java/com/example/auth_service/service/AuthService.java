package com.example.auth_service.service;


import com.example.auth_service.client.UserClient;
import com.example.auth_service.dto.AuthResponse;
import com.example.auth_service.dto.LoginRequest;
import com.example.auth_service.dto.RegisterRequest;
import com.example.auth_service.dto.UserResponse;

import com.example.auth_service.exception.LoginFailExceptionHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {

    private final UserClient userClient;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthService(UserClient userClient, BCryptPasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userClient = userClient;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse register(RegisterRequest registerRequest) {
        String hashedPassword = passwordEncoder.encode(registerRequest.password());
        RegisterRequest hashedRequest = new RegisterRequest(
                registerRequest.firstname(),
                registerRequest.lastname(),
                registerRequest.email(),
                registerRequest.username(),
                hashedPassword,
                registerRequest.role()
        );
        UserResponse user = userClient.register(hashedRequest).getBody();
        String token = jwtService.generateToken(user.email());
        return new AuthResponse(token, user);
    }

    public AuthResponse login(LoginRequest loginRequest) {

        UserResponse user=userClient.getUserByEmail(loginRequest.email()).getBody();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));

        if (!authentication.isAuthenticated()) {
           throw new LoginFailExceptionHandler("Email or password incorrect");
        }
        String token = "Bearer "+jwtService.generateToken(loginRequest.email());
        System.out.println(token);
        return new AuthResponse(token,user);
    }
}