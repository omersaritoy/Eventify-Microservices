package com.example.auth_service.exception;

public class UsernameAlreadyExistsException extends RuntimeException {


    public UsernameAlreadyExistsException(String messagee) {
        super(messagee);
    }
}
