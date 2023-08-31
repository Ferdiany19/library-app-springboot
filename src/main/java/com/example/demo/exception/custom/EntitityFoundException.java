package com.example.demo.exception.custom;

public class EntitityFoundException extends RuntimeException {
    public EntitityFoundException(String message) {
        super(message);
    }
}
