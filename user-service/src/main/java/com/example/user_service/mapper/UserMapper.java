package com.example.user_service.mapper;

import com.example.user_service.dto.UserRequest;
import com.example.user_service.dto.UserResponse;
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

    public static User toModel(UserRequest request) {
        User user = new User();
        user.setEmail(request.email());
        user.setUsername(request.username());
        user.setPasswordHash(request.password());
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setPhone(request.phone());
        user.setRole(Role.valueOf(request.role()));
        user.setProfileImageUrl(request.profileImageUrl());
        user.setBio(request.bio());
        user.setDateOfBirth(request.dateOfBirth());
        user.setGender(request.gender());
        user.setLocation(request.location());
        user.setActive(true);
        user.setVerified(false);

        return user;
    }


}
