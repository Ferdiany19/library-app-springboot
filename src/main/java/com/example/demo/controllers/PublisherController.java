package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payloads.req.PublisherRequest;
import com.example.demo.payloads.res.ResponseHander;

import com.example.demo.service.publisher.PublisherService;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    @PostMapping
    public ResponseEntity<?> createPublishers(@RequestBody PublisherRequest request) {
        // try {
        return publisherService.addPublisherService(request);
        // } catch (Exception e) {
        // return ResponseHander.responseError(500, e.getMessage(), null);
        // }
    }

    @GetMapping
    public ResponseEntity<?> getPublishers() {
        // try {
        return publisherService.getPublishersService();
        // } catch (Exception e) {
        // return ResponseHander.responseError(500, e.getMessage(), null);
        // }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPublisherById(@PathVariable String id) {
        // try {
        return publisherService.getPublisherByIdService(id);
        // } catch (Exception e) {
        // return ResponseHander.responseError(500, e.getMessage(), null);
        // }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getPublisherByName(@PathVariable String name) {
        // try {
        return publisherService.getPublisherByNameService(name);
        // } catch (Exception e) {
        // return ResponseHander.responseError(500, e.getMessage(), null);
        // }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePublisherById(@PathVariable String id) {
        // try {
        return publisherService.deletePublisherByIdService(id);
        // } catch (Exception e) {
        // return ResponseHander.responseError(500, e.getMessage(), null);
        // }
    }
}
