package com.example.user_service.mapper;

import com.example.user_service.dto.RegisterRequest;
import com.example.user_service.dto.UserResponse;
import com.example.user_service.dto.UserUpdateRequest;
import com.example.user_service.model.Role;
import com.example.user_service.model.User;

public class UserMapper {


    public static UserResponse toDto(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getProfileImageUrl(),
                user.getBio(),
                user.getDateOfBirth(),
                user.getGender(),
                user.getLocation(),
                user.getVerified(),
                user.getActive(),
                user.getRole().toString(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
    public static User toModel(RegisterRequest registerRequest) {
        User user = new User();
        user.setEmail(registerRequest.email());
        user.setUsername(registerRequest.username());
        user.setPasswordHash(registerRequest.password());
        user.setFirstName(registerRequest.firstname());
        user.setLastName(registerRequest.lastname());
        user.setRole(Role.valueOf(registerRequest.role()));
        return user;
    }




}
