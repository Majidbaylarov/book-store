package com.example.Book.Store.Api.service;

import com.example.Book.Store.Api.dto.AuthorDto;
import com.example.Book.Store.Api.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    AuthorDto addAuthor(AuthorDto authorDto);

    List<AuthorDto> getAllAuthors();

    AuthorDto getAuthorById(Long id);

    void deleteAuthor(Long authorId);

    AuthorDto updateAuthor(AuthorDto author);


}
