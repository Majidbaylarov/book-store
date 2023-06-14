package com.example.Book.Store.Api.controller;

import com.example.Book.Store.Api.dto.BookDto;
import com.example.Book.Store.Api.dto.PublisherDto;
import com.example.Book.Store.Api.service.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping
    public ResponseEntity<PublisherDto> addBook(@RequestBody PublisherDto publisherDto) {
        System.out.println("publisherDto = " + publisherDto);
        PublisherDto savedPublisher = publisherService.addPublisher(publisherDto);
        return new ResponseEntity<>(savedPublisher, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PublisherDto> getBookById(@PathVariable("id") Long bookId) {
        PublisherDto publisher = publisherService.getPublisherById(bookId);
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PublisherDto>> getAllPublishers() {
        List<PublisherDto> publisher = publisherService.getAllPublishers();
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }

    @DeleteMapping ("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long publisherId){
        publisherService.deletePublisher(publisherId);
        return new ResponseEntity<>("Publisher succesfully deleted!", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PublisherDto> updateBook(@RequestBody PublisherDto publisherDto) {
        PublisherDto publisherDtos = publisherService.updatePublisher(publisherDto);
        return ResponseEntity.ok().body(publisherDtos);

    }
}
