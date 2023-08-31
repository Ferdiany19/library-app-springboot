package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Book;

public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByIsDeleted(Boolean isDeleted);

    Book findByTitle(String title);
}
