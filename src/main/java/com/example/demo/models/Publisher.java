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
@Table(name = "publisher")

public class Publisher {

    @Id
    @UuidGenerator
    private String id;

    @Column(length = 100)
    private String name;
    @Column(length = 100)
    private String address;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private Boolean isDeleted = false;

    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }

}
