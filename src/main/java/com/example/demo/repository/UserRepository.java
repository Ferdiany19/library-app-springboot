package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);

    User findByPassword(String password);
}
