package com.example.demo.service.transaction;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.Book;
import com.example.demo.models.Transaction;
import com.example.demo.models.User;
import com.example.demo.payloads.req.BorrowTransactionRequest;
import com.example.demo.payloads.req.ReturnTransactionRequest;
import com.example.demo.payloads.res.ResponseHander;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.validation.BookValidation;
import com.example.demo.validation.UserVaidation;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookValidation bookValidation;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserVaidation userVaidation;

    @Override
    public ResponseEntity<?> borrowBookService(BorrowTransactionRequest request) {
        Book book = bookRepository.findByTitle(request.getJudul());
        bookValidation.validateBook(book);

        User user = userRepository.findByUsername(request.getUsername());
        userVaidation.validateUser(user);

        Transaction transaction = new Transaction(book, user);
        book.setIsDeleted(true);
        transactionRepository.save(transaction);

        return ResponseHander.responseData(201, "Success Borrow Book", transaction);
    }

    @Override
    public ResponseEntity<?> returnBookService(ReturnTransactionRequest request) {
        Transaction transaction = transactionRepository.findById(request.getId()).orElseThrow(() -> {
            throw new NoSuchElementException("id is not found");
        });
        System.out.println(transaction);
        Book book = transaction.getBook();

        book.setIsDeleted(false);
        bookRepository.save(book);
        transaction.setIsDeleted(true);

        transactionRepository.save(transaction);

        return ResponseHander.responseMessage(201, "Success Return Book", true);
    }

    @Override
    public ResponseEntity<?> getBooksService(Boolean isDeleted) {
        List<Transaction> transactions;
        if (isDeleted == null) {
            transactions = transactionRepository.findAll();
        } else {
            transactions = transactionRepository.findByIsDeleted(isDeleted);
        }

        return ResponseHander.responseData(200, "Success ", transactions);

    }

}
