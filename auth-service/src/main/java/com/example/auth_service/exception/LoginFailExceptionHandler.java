package com.example.auth_service.exception;

public class LoginFailExceptionHandler extends RuntimeException {
    public LoginFailExceptionHandler(String message) {
        super(message);
    }
}
