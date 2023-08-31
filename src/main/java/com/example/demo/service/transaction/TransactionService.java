package com.example.demo.service.transaction;

import org.springframework.http.ResponseEntity;

import com.example.demo.payloads.req.BorrowTransactionRequest;
import com.example.demo.payloads.req.ReturnTransactionRequest;

public interface TransactionService {
    ResponseEntity<?> borrowBookService(BorrowTransactionRequest request);

    ResponseEntity<?> returnBookService(ReturnTransactionRequest request);

    ResponseEntity<?> getBooksService(Boolean isDeleted);

}
