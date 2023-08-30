package com.example.demo.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @UuidGenerator
    private String id;

    @Column(length = 100)
    private String username;

    @Column(length = 100)
    private String email;

    @Column(length = 100)
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
