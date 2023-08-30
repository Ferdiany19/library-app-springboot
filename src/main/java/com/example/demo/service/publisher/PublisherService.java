package com.example.demo.service.publisher;

import org.springframework.http.ResponseEntity;

import com.example.demo.payloads.req.PublisherRequest;

public interface PublisherService {

    ResponseEntity<?> addPublisherService(PublisherRequest request);

    ResponseEntity<?> getPublishersService();

    ResponseEntity<?> getPublisherByIdService(String id);

    ResponseEntity<?> updatePublisherByIdService(String id, PublisherRequest request);

    ResponseEntity<?> deletePublisherByIdService(String id);

    ResponseEntity<?> getPublisherByNameService(String name);

    ResponseEntity<?> getPublisherNotDeletedService(Boolean isDeleted);

}
