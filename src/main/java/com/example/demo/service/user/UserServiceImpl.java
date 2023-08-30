package com.example.demo.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.payloads.req.RegisterRequest;
import com.example.demo.payloads.res.ResponseHander;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<?> registerUserService(RegisterRequest request) {

        User user = new User(request.getUsername(), request.getEmail(), request.getPassword());
        userRepository.save(user);

        return ResponseHander.responseData(200, "Success register user", user);
    
    }

}
