package com.example.demo.validation;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.example.demo.models.Book;

@Component
public class BookValidation {
    public void validateBook(Book book) {
        if (book == null || Objects.isNull(book)) {
            throw new NoSuchElementException("Book is not found");
        }

        if (book.getIsDeleted()) {
            throw new NoSuchElementException("Buku ini sudah dipinjam");
        }

    }
}
