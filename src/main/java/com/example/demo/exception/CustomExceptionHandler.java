package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.payloads.res.ResponseHander;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> globalException(Exception e) {
        return ResponseHander.responseError(500, e.getMessage(), null);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalExpression(IllegalArgumentException e) {
        return ResponseHander.responseError(400, e.getMessage(), null);
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<?> handleNoElement(NoSuchElementException e) {
        return ResponseHander.responseError(404, e.getMessage(), null);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgNotValid(MethodArgumentNotValidException e) {
        Map<String, Object> errorMap = new HashMap<>();

        e.getFieldErrors().forEach(err -> {
            errorMap.put(err.getField(), err.getDefaultMessage());
        });
        return ResponseHander.responseError(e.getStatusCode().value(), "error validation", errorMap);
    }
}
