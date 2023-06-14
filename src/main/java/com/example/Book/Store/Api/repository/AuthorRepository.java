package com.example.Book.Store.Api.repository;

import com.example.Book.Store.Api.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
