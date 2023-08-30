package com.example.demo.service.book;

import org.springframework.http.ResponseEntity;

import com.example.demo.payloads.req.BookRequest;

public interface BookService {
    // create buku
    ResponseEntity<?> addBookService(BookRequest request);

    // get semua book or by status deleted
    ResponseEntity<?> getBooksService(Boolean isDeleted);

    // get book by id
    ResponseEntity<?> getBookByIdService(String id);

    // update book by id
    ResponseEntity<?> updateBookByIdService(String id, BookRequest request);

    // deleted book
    ResponseEntity<?> deleteBookByIdService(String id);
}
