package com.example.demo.service.user;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.custom.EntitityFoundException;
import com.example.demo.models.User;
import com.example.demo.payloads.req.LoginRequest;
import com.example.demo.payloads.req.RegisterRequest;
import com.example.demo.payloads.res.ResponseHander;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<?> registerUserService(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new NoSuchElementException("email sudah ada");
        }

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new EntitityFoundException("username sudah ada");
        }
        User user = new User(request.getUsername(), request.getEmail(), request.getPassword());
        userRepository.save(user);

        return ResponseHander.responseData(201, "Success register user", user);

    }

    @Override
    public ResponseEntity<?> loginUserService(LoginRequest request) {
        User userEmail = userRepository.findByEmail(request.getEmail());
        if (userEmail == null) {
            throw new EntitityFoundException("Email is not found!");
        }
        if (!userEmail.getPassword().equals(request.getPassword())) {
            throw new NoSuchElementException("Password doesn't match!");
        }
        return ResponseHander.responseMessage(200, "Login Success", true);
    }

}
