package com.example.Book.Store.Api.repository;

import com.example.Book.Store.Api.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
