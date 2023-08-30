package com.example.demo.service.author;

import org.springframework.http.ResponseEntity;

import com.example.demo.payloads.req.AuthorRequest;

public interface AuthorService {
    ResponseEntity<?> addAuthorService(AuthorRequest request);

    ResponseEntity<?> getAuthorsService();

    ResponseEntity<?> getAuthorByIdService(String id);

    ResponseEntity<?> updateAuthorByIdService(String id, AuthorRequest request);

    ResponseEntity<?> deleteAuthorByIdService(String id);

    ResponseEntity<?> getAuthorByNameService(String name);
}
