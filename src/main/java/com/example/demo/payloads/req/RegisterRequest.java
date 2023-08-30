package com.example.demo.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotEmpty(message = "Username cannot be empty!")
    private String username;
    @NotEmpty(message = "Email cannot be empty!")
    private String email;
    @NotEmpty(message = "Password cannot be empty!")
    @Size(min = 8, message = "Password minimun 8 characters")
    private String password;
}
