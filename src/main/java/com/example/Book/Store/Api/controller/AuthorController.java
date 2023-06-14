package com.example.Book.Store.Api.controller;

import com.example.Book.Store.Api.dto.AuthorDto;
import com.example.Book.Store.Api.dto.BookDto;
import com.example.Book.Store.Api.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorDto> addAuthor(@RequestBody AuthorDto authorDto){
        AuthorDto createdAuthorDto=authorService.addAuthor(authorDto);

        return new ResponseEntity<>(createdAuthorDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors(){
        List<AuthorDto> authorDtos=authorService.getAllAuthors();
        return new ResponseEntity<>(authorDtos, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable ("id") Long id){
        authorService.deleteAuthor(id);
        return new ResponseEntity<>("Author succesfully deleted!", HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable ("id") Long id){
        AuthorDto authorDto=authorService.getAuthorById(id);
        return new ResponseEntity<>(authorDto, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<AuthorDto> updateBook(@RequestBody AuthorDto authorDto){
        AuthorDto authorDtos=authorService.updateAuthor(authorDto);



         return ResponseEntity.ok().body(authorDtos);

    }






}
