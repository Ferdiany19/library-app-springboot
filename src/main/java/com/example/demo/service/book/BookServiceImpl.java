package com.example.demo.service.book;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.models.Publisher;
import com.example.demo.payloads.req.BookRequest;
import com.example.demo.payloads.res.ResponseHander;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PublisherRepository;
import com.example.demo.validation.AuthorValidation;
import com.example.demo.validation.PublisherValidation;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    AuthorValidation authorValidation;

    @Autowired
    PublisherValidation publisherValidation;

    @Override
    public ResponseEntity<?> addBookService(BookRequest request) {
        // cek input dari user
        // mencari data author dan publisher dari request yang masuk
        Author author = authorRepository.findByName(request.getNamaPengarang());
        Publisher publisher = publisherRepository.findByName(request.getNamaPenerbit());
        // validasi pencarian

        authorValidation.validateAuthor(author);
        publisherValidation.validatePublisher(publisher);

        // buatkan object entitas dari buku
        Book book = new Book(request.getJudul(), request.getTahunTerbit(), author, publisher);

        bookRepository.save(book);

        // bisa pake response message yang tidak menampilkan data tapi isSuccess truee
        // or false
        return ResponseHander.responseData(201, "Book successfully addedd", book);
    }

    @Override
    public ResponseEntity<?> getBooksService(Boolean isDeleted) {
        List<Book> books = new ArrayList<>();

        // cek isdeleted null atau tidaj
        if (isDeleted == null) {
            books = bookRepository.findAll();
        } else {
            books = bookRepository.findByIsDeleted(isDeleted);
        }
        return ResponseHander.responseData(200, "Success", books);
    }

    @Override
    public ResponseEntity<?> getBookByIdService(String id) {
        if (!bookRepository.existsById(id)) {
            throw new NoSuchElementException("Id tidak ditemukan!");
        }
        // cari id nya dulu
        Book book = bookRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("id not found!");
        });
        return ResponseHander.responseData(200, "success", book);
    }

    @Override
    public ResponseEntity<?> updateBookByIdService(String id, BookRequest request) {
        // cari id nya dulu
        Book book = bookRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("id not found!");
        });

        if (request.getJudul() != "") {
            book.setTitle(request.getJudul());
        }

        if (request.getTahunTerbit() != "") {
            book.setYear(request.getTahunTerbit());
        }

        if (request.getNamaPengarang() != "") {
            Author author = authorRepository.findByName(request.getNamaPengarang());
            authorValidation.validateAuthor(author);
            book.setAuthor(author);
        }

        if (request.getNamaPenerbit() != "") {
            Publisher publisher = publisherRepository.findByName(request.getNamaPenerbit());
            publisherValidation.validatePublisher(publisher);
            book.setPublisher(publisher);
        }

        bookRepository.save(book);
        return ResponseHander.responseData(200, "Success", book);
    }

    @Override
    public ResponseEntity<?> deleteBookByIdService(String id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("id not found!");
        });

        book.setIsDeleted(true);

        bookRepository.save(book);

        return ResponseHander.responseData(500, "Success", null);
    }

}
