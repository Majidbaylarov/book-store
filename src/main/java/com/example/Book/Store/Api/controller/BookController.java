package com.example.Book.Store.Api.controller;

import com.example.Book.Store.Api.dto.AuthorDto;
import com.example.Book.Store.Api.dto.BookDto;
import com.example.Book.Store.Api.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto book) {
        BookDto savedBook = bookService.addBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<BookDto> getBookById(@PathVariable("id") Long bookId) {
        BookDto book = bookService.getBookById(bookId);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<BookDto>> getAllBooks(@RequestParam int pageNo, @RequestParam int pageSize) {
        List<BookDto> books = bookService.getAllBooks(pageNo, pageSize);
        return ResponseEntity.ok().body(books);
    }

    @DeleteMapping ("{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long bookId){
       bookService.deleteBook(bookId);
       return new ResponseEntity<>("Book succesfully deleted!", HttpStatus.OK);
    }

    @PutMapping("/")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto){
        BookDto bookDtos=bookService.updateBook(bookDto);
        return ResponseEntity.ok().body(bookDtos);
    }



}
