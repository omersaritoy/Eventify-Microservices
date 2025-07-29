package com.example.auth_service.dto;

public enum Role {
    ADMIN("Admin"),
    ORGANIZER("Organizer"),
    MODERATOR("Moderator"),
    SPONSOR("Sponsor"),
    ATTENDEE("Attendee"),
    SUPPORT("Support");

    private final String role;
    Role(String role) {
        this.role = role;
    }
}
