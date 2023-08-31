package com.example.demo.validation;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.example.demo.models.Publisher;
import com.example.demo.models.User;

@Component
public class UserVaidation {
    public void validateUser(User user) {
        if (user == null || Objects.isNull(user)) {
            throw new NoSuchElementException("User name is not found!");
        }
    }
}
