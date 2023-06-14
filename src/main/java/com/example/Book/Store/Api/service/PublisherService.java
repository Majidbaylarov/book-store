package com.example.Book.Store.Api.service;


import com.example.Book.Store.Api.dto.BookDto;
import com.example.Book.Store.Api.dto.PublisherDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PublisherService {

    PublisherDto addPublisher(PublisherDto publisherDto);
    PublisherDto getPublisherById(Long publisherId);
    List<PublisherDto> getAllPublishers();
    PublisherDto updatePublisher(PublisherDto publisherDto);

    void  deletePublisher(Long publisherId);

}
