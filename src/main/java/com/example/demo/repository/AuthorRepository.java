package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Author;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, String> {
    List<Author> findByNameContaining(String name);

    Author findByName(String name);

    @Query(value = "SELECT * FROM authors WHERE name = ?", nativeQuery = true)
    List<Author> getAuthorByName(String name);
}