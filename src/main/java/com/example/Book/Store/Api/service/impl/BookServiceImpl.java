package com.example.Book.Store.Api.service.impl;

import com.example.Book.Store.Api.dto.BookDto;
import com.example.Book.Store.Api.mapper.BookMapper;
import com.example.Book.Store.Api.model.Book;
import com.example.Book.Store.Api.repository.BookRepository;
import com.example.Book.Store.Api.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto addBook(BookDto bookDto) {
        Book book = BookMapper.MAPPER.mapToBook(bookDto);
        Book savedBook = bookRepository.save(book);
        BookDto savedBookDto = BookMapper.MAPPER.mapToBookDto(savedBook);

        return savedBookDto;
    }

    @Override
    public BookDto getBookById(Long bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        Book book = optionalBook.get();
        return BookMapper.MAPPER.mapToBookDto(optionalBook.get());
    }

    @Override
    public List<BookDto> getAllBooks(int pageNo, int pageSize) {
        Pageable pageable =  PageRequest.of(pageNo-1, pageSize);
        Page<Book> books = bookRepository.findAll(pageable);
        return books.stream()
                .map(BookMapper.MAPPER::mapToBookDto).
                collect(Collectors.toList());
    }

    @Override
    public BookDto updateBook(BookDto book) {
        Book existingBook=bookRepository.findById(book.getId()).get();
        existingBook.setName(book.getName());
        existingBook.setId(book.getId());
        Book updatedBook=bookRepository.save(existingBook);
        return BookMapper.MAPPER.mapToBookDto(updatedBook);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

}

