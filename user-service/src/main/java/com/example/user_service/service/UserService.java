package com.example.user_service.service;

import com.example.user_service.dto.RegisterRequest;
import com.example.user_service.dto.UserResponse;
import com.example.user_service.dto.UserUpdateRequest;
import com.example.user_service.exception.EmailAlreadyExistsException;
import com.example.user_service.exception.UserNotFoundException;
import com.example.user_service.exception.UsernameAlreadyExistsException;
import com.example.user_service.mapper.UserMapper;
import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::toDto).toList();
    }

    public UserResponse register(RegisterRequest registerRequest){
        User user=userRepository.save(UserMapper.toModel(registerRequest));
        return UserMapper.toDto(user);
    }

    public UserResponse getUserById(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return UserMapper.toDto(user);
    }
    public UserResponse getUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));
        return UserMapper.toDto(user);
    }
    public UserResponse getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(()-> new UserNotFoundException("User not found with email: " + email));
        return UserMapper.toDto(user);
    }

    public UserResponse updateUser(UUID id, UserUpdateRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        boolean isEmailChanged = !user.getEmail().equals(request.email());
        boolean isEmailAlreadyExist = userRepository.existsByEmail(request.email());
        boolean isUsernameChanged = !user.getUsername().equals(request.username());
        boolean isUsernameAlreadyExist = userRepository.existsByUsername(request.username());
        if (isEmailChanged && isEmailAlreadyExist) {
            throw new EmailAlreadyExistsException("A user with this email already exists: " + request.email());
        }
        if (isUsernameChanged && isUsernameAlreadyExist) {
            throw new UsernameAlreadyExistsException("A user with this username already exists: " + request.username());
        }
        user.setEmail(request.email());
        user.setUsername(request.username());
        user.setPasswordHash(request.password());
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setPhone(request.phone());
        user.setProfileImageUrl(request.profileImageUrl());
        user.setBio(request.bio());
        user.setDateOfBirth(request.dateOfBirth());
        user.setGender(request.gender());
        user.setLocation(request.location());
        user.setUpdatedAt(LocalDateTime.now());
        return UserMapper.toDto(userRepository.save(user));

    }


}
