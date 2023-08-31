package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payloads.req.BorrowTransactionRequest;
import com.example.demo.payloads.req.ReturnTransactionRequest;
import com.example.demo.service.transaction.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> borrowBook(@RequestBody @Valid BorrowTransactionRequest request) {
        return transactionService.borrowBookService(request);
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnBook(@RequestBody ReturnTransactionRequest request) {
        return transactionService.returnBookService(request);
    }

    @GetMapping
    public ResponseEntity<?> getTransactions(@RequestParam(value = "deleted", defaultValue = "") Boolean isDeleted) {
        return transactionService.getBooksService(isDeleted);
    }
}
