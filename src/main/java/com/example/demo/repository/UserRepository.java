package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);

    User findByPassword(String password);

    User findByUsername(String username);

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);

    // Boolean existByPassword(String password);
}
