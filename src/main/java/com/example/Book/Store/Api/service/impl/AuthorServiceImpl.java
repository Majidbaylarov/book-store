package com.example.Book.Store.Api.service.impl;


import com.example.Book.Store.Api.dto.AuthorDto;
import com.example.Book.Store.Api.mapper.AuthorMapper;
import com.example.Book.Store.Api.mapper.BookMapper;
import com.example.Book.Store.Api.model.Author;
import com.example.Book.Store.Api.model.Book;
import com.example.Book.Store.Api.repository.AuthorRepository;
import com.example.Book.Store.Api.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorDto addAuthor(AuthorDto authorDto) {
        Author author = AuthorMapper.MAPPER.mapToAuthor(authorDto);
        Author savedAuthor = authorRepository.save(author);
        AuthorDto savedAuthorDto = AuthorMapper.MAPPER.mapToAuthorDto(savedAuthor);
        log.info("IN addAuthor - Author: {} successfully added", savedAuthorDto);
        return savedAuthorDto;

    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors=authorRepository.findAll();
        return authors.stream().map(author -> AuthorMapper.MAPPER.mapToAuthorDto(author))
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDto getAuthorById(Long id) {
        Optional<Author> optionalAuthor=authorRepository.findById(id);
        Author author=optionalAuthor.get();
        return AuthorMapper.MAPPER.mapToAuthorDto(author);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        authorRepository.deleteById(authorId);
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto author) {
        Author existingAuthor=authorRepository.findById(author.getId()).get();
        existingAuthor.setName(author.getName());
        existingAuthor.setId(author.getId());
        existingAuthor.setSurname((author.getSurname()));
        Author updatedAuthor=authorRepository.save(existingAuthor);
        return AuthorMapper.MAPPER.mapToAuthorDto(updatedAuthor);
    }


}
