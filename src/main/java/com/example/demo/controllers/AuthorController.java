package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payloads.req.AuthorRequest;
import com.example.demo.payloads.res.ResponseHander;
import com.example.demo.service.author.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping
    public ResponseEntity<?> createAuthor(@RequestBody AuthorRequest request) {
        try {
            return authorService.addAuthorService(request);
        } catch (Exception e) {
            return ResponseHander.responseError(500, e.getMessage(), null);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAuthors() {
        try {
            return authorService.getAuthorsService();
        } catch (Exception e) {
            return ResponseHander.responseError(500, e.getMessage(), null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable String id) {
        try {
            return authorService.getAuthorByIdService(id);
        } catch (Exception e) {
            return ResponseHander.responseError(500, e.getMessage(), null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthorById(@PathVariable String id) {
        try {
            return authorService.deleteAuthorByIdService(id);
        } catch (Exception e) {
            return ResponseHander.responseError(500, e.getMessage(), null);
        }
    }
}
