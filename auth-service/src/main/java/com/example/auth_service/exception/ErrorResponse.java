package com.example.auth_service.exception;


import java.time.LocalDateTime;

public class ErrorResponse {
    private String message;
    private String path;
    private int status;
    private LocalDateTime timestamp;

    public ErrorResponse(String message, String path, int status) {
        this.message = message;
        this.path = path;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

