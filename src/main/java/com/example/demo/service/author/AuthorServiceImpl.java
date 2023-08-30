package com.example.demo.service.author;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.Author;
import com.example.demo.payloads.req.AuthorRequest;
import com.example.demo.payloads.res.ResponseHander;
import com.example.demo.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public ResponseEntity<?> addAuthorService(AuthorRequest request) {
        // cek request, ada yg null atau tidak
        if (request.getName() == null || request.getName() == "") {
            throw new IllegalArgumentException("Name required!");
        }

        Author author = new Author(request.getName(), request.getSocialMedia());
        authorRepository.save(author);

        return ResponseHander.responseData(HttpStatus.CREATED.value(), "Successfully added", author);
    }

    @Override
    public ResponseEntity<?> getAuthorsService() {
        List<Author> authors = authorRepository.findAll();

        return ResponseHander.responseData(200, "success", authors);

    }

    @Override
    public ResponseEntity<?> getAuthorByIdService(String id) {
        if (!authorRepository.existsById(id)) {
            throw new NoSuchElementException("Id tidak ditemukan!");
        }

        // KALO DATANYA UNIK, SINGLE AJA
        // KALO DATANYA BANYAK, BIS APAKE LIST<AUTHOR>
        Author author = authorRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("id not found!");
        });

        return ResponseHander.responseData(200, "success", author);
    }

    @Override
    public ResponseEntity<?> updateAuthorByIdService(String id, AuthorRequest request) {
        // cari author
        Author author = authorRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("id not found!");
        });

        if (request.getName() == "") {
            author.setName(request.getName());
        }

        return ResponseHander.responseData(200, "Success update", author);
    }

    @Override
    public ResponseEntity<?> deleteAuthorByIdService(String id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("id not found!");
        });

        author.setIsDeleted(true);
        authorRepository.save(author);

        return ResponseHander.responseData(200, "success deleted!", null);
    }

    @Override
    public ResponseEntity<?> getAuthorByNameService(String name) {
        List<Author> authors = authorRepository.findByNameContaining(name);

        return ResponseHander.responseData(200, "success", authors);
    }

}
