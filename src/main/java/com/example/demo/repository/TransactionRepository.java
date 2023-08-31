package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Book;
import com.example.demo.models.Transaction;
import com.example.demo.models.User;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    Boolean existsByUser(User user);

    List<Transaction> findByUser(User user);

    List<Transaction> findByBook(Book book);

    List<Transaction> findByIsDeleted(Boolean isDeleted);
}
