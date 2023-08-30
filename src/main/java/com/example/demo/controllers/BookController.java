package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payloads.req.BookRequest;
import com.example.demo.payloads.res.ResponseHander;
import com.example.demo.service.book.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody BookRequest request) {
        try {
            return bookService.addBookService(request);
        } catch (Exception e) {
            return ResponseHander.responseError(500, e.getMessage(), null);
        }
    }

    @GetMapping
    public ResponseEntity<?> getBooks(@RequestParam(value = "deleted", defaultValue = "") Boolean isDeleted) {
        try {
            return bookService.getBooksService(isDeleted);
        } catch (Exception e) {
            return ResponseHander.responseError(500, e.getMessage(), null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable String id) {
        try {
            return bookService.getBookByIdService(id);

        } catch (Exception e) {
            return ResponseHander.responseError(500, e.getMessage(), null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBookById(@PathVariable String id, @RequestBody @Valid BookRequest request) {
        try {
            return bookService.updateBookByIdService(id, request);

        } catch (Exception e) {
            return ResponseHander.responseError(500, e.getMessage(), null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable String id) {
        try {
            return bookService.deleteBookByIdService(id);

        } catch (Exception e) {
            return ResponseHander.responseError(500, e.getMessage(), null);
        }
    }
}