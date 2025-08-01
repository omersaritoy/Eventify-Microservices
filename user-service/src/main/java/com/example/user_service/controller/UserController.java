package com.example.user_service.controller;



import com.example.user_service.dto.RegisterRequest;
import com.example.user_service.dto.UserResponse;
import com.example.user_service.dto.UserUpdateRequest;
import com.example.user_service.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.example.user_service.config.RestApis.*;
@RestController
@RequestMapping(USERSERVICE)
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(REGISTER)
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(userService.register(registerRequest));
    }
    @GetMapping(GETALL)
    public ResponseEntity<List<UserResponse>> getAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping(GETUSER)
    public ResponseEntity<UserResponse> getUser(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @PutMapping(UPDATE)
    public ResponseEntity<UserResponse> updateUser(@PathVariable UUID id,@RequestBody UserUpdateRequest userRequest) {
        return ResponseEntity.ok(userService.updateUser(id,userRequest));
    }
    @GetMapping(GETBYUSERNAME)
    public ResponseEntity<UserResponse> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }
    @GetMapping(GETBYEMAIL)
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }
}
