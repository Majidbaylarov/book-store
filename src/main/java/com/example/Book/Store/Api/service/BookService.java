package com.example.Book.Store.Api.service;

import com.example.Book.Store.Api.dto.BookDto;
import com.example.Book.Store.Api.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookService {
    BookDto addBook(BookDto bookDto);
    BookDto getBookById(Long bookId);
    List<BookDto> getAllBooks(int size, int page);
    BookDto updateBook(BookDto book);

    void  deleteBook(Long bookId);
}
