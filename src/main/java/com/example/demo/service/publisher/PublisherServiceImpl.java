package com.example.demo.service.publisher;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.Publisher;
import com.example.demo.payloads.req.PublisherRequest;
import com.example.demo.payloads.res.ResponseHander;
import com.example.demo.repository.PublisherRepository;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public ResponseEntity<?> addPublisherService(PublisherRequest request) {
        if (request.getName() == null || request.getName() == "") {
            throw new IllegalArgumentException("Name required!");
        }

        Publisher publisher = new Publisher(request.getName(), request.getAddress());
        publisherRepository.save(publisher);

        return ResponseHander.responseData(HttpStatus.CREATED.value(), "Successfully added", publisher);
    }

    @Override
    public ResponseEntity<?> getPublishersService() {
        List<Publisher> publishers = publisherRepository.findAll();

        return ResponseHander.responseData(200, "success", publishers);
    }

    @Override
    public ResponseEntity<?> getPublisherByIdService(String id) {
        if (!publisherRepository.existsById(id)) {
            throw new NoSuchElementException("Id tidak ditemukan!");
        }

        // KALO DATANYA UNIK, SINGLE AJA
        // KALO DATANYA BANYAK, BIS APAKE LIST<AUTHOR>
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("id not found!");
        });

        return ResponseHander.responseData(200, "success", publisher);
    }

    @Override
    public ResponseEntity<?> updatePublisherByIdService(String id, PublisherRequest request) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("id not found!");
        });

        if (request.getName() == "") {
            publisher.setName(request.getName());
        }
        if (request.getAddress() == "") {
            publisher.setName(request.getAddress());
        }

        return ResponseHander.responseData(200, "Success update", publisher);
    }

    @Override
    public ResponseEntity<?> deletePublisherByIdService(String id) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("id not found!");
        });

        publisher.setIsDeleted(true);
        publisherRepository.save(publisher);

        return ResponseHander.responseData(200, "success deleted!", null);
    }

    @Override
    public ResponseEntity<?> getPublisherByNameService(String name) {
        List<Publisher> publishers = publisherRepository.findByNameContaining(name);

        return ResponseHander.responseData(200, "success", publishers);
    }

    @Override
    public ResponseEntity<?> getPublisherNotDeletedService() {
        List<Publisher> publishers = publisherRepository.getDeletedPublisherByDelete();

        return ResponseHander.responseData(200, "success", publishers);
    }

}
