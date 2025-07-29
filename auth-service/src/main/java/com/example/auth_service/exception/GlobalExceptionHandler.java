package com.example.auth_service.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleEmailAlreadyExists(EmailAlreadyExistsException ex, HttpServletRequest request) {
        System.out.println("Email already exists:"+ex.getMessage());
        ErrorResponse error = new ErrorResponse(ex.getMessage(),request.getRequestURI(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUsernameAlreadyExists(UsernameAlreadyExistsException ex, HttpServletRequest request) {
        System.out.println("Username already exists:"+ex.getMessage());
        ErrorResponse error = new ErrorResponse(ex.getMessage(),request.getRequestURI(),HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ExceptionHandler(LoginFailExceptionHandler.class)
    public ResponseEntity<ErrorResponse> handleLoginFail(LoginFailExceptionHandler handler, HttpServletRequest request) {
        System.out.println("Login fail:"+handler.getMessage());
        ErrorResponse error = new ErrorResponse(handler.getMessage(),request.getRequestURI(),HttpStatus.UNAUTHORIZED.value());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }
}
