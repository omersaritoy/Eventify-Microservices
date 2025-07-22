package com.example.auth_service.client;

import com.example.auth_service.dto.UserRequest;
import com.example.auth_service.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="user-service",url = "localhost:8081")
public interface UserClient {
    @PostMapping("/dev/v1/user/register")
    ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest);


}
