package com.example.auth_service.client;

import com.example.auth_service.dto.RegisterRequest;
import com.example.auth_service.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="user-service",url = "http://localhost:8081/dev/v1/user")
public interface UserClient {
    @PostMapping("/register")
    ResponseEntity<UserResponse> register(@RequestBody RegisterRequest registerRequest);

    @GetMapping("/get-by-email/{email}")
    ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email);

    @GetMapping("/get-by-username/{username}")
    ResponseEntity<UserResponse> getUserByUsername(@PathVariable String username);

}
