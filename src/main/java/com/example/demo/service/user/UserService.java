package com.example.demo.service.user;

import org.springframework.http.ResponseEntity;

import com.example.demo.payloads.req.LoginRequest;
import com.example.demo.payloads.req.RegisterRequest;

public interface UserService {
    ResponseEntity<?> registerUserService(RegisterRequest request);

    ResponseEntity<?> loginUserService(LoginRequest request);
}
