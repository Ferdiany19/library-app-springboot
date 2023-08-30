package com.example.demo.validation;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.example.demo.models.Publisher;

@Component
public class PublisherValidation {
    public void validatePublisher(Publisher publisher) {
        if (publisher == null || Objects.isNull(publisher)) {
            throw new NoSuchElementException("Publisher name is not found!");
        }
    }
}
