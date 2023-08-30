package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, String> {
    List<Publisher> findByNameContaining(String name);

    Publisher findByName(String name);

    @Query(value = "SELECT * FROM publisher WHERE isDeleted = 'false'", nativeQuery = true)
    List<Publisher> getDeletedPublisherByDelete();

    List<Publisher> findByIsDeleted(Boolean isDeleted);
}
