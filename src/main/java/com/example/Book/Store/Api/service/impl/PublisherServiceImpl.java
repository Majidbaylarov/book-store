package com.example.Book.Store.Api.service.impl;

import com.example.Book.Store.Api.dto.PublisherDto;
import com.example.Book.Store.Api.mapper.BookMapper;
import com.example.Book.Store.Api.mapper.PublisherMapper;
import com.example.Book.Store.Api.model.Book;
import com.example.Book.Store.Api.model.Publisher;
import com.example.Book.Store.Api.repository.PublisherRepository;
import com.example.Book.Store.Api.service.PublisherService;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public PublisherDto addPublisher(PublisherDto publisherDto) {
        Publisher publisher = PublisherMapper.MAPPER.mapToPublisher(publisherDto);
        Publisher addedPublisher = publisherRepository.save(publisher);
        PublisherDto publisherDtos = PublisherMapper.MAPPER.mapToPublisherDto(publisher);
        return publisherDtos;
    }

    @Override
    public PublisherDto getPublisherById(Long publisherId) {
        Optional<Publisher> optionalPublisher=publisherRepository.findById(publisherId);
        Publisher publisher=optionalPublisher.get();
        return PublisherMapper.MAPPER.mapToPublisherDto(optionalPublisher.get());
    }

    @Override
    public List<PublisherDto> getAllPublishers() {
        List<Publisher> publishers = publisherRepository.findAll();
        return publishers.stream().map((publisher) -> PublisherMapper.MAPPER.mapToPublisherDto(publisher)).collect(Collectors.toList());
    }

    @Override
    public PublisherDto updatePublisher(PublisherDto publisherDto) {
        Publisher existingPublisher=publisherRepository.findById(publisherDto.getId()).get();
        existingPublisher.setName(publisherDto.getName());
        existingPublisher.setId(publisherDto.getId());
        Publisher updatedPublisher=publisherRepository.save(existingPublisher);
        return PublisherMapper.MAPPER.mapToPublisherDto(updatedPublisher);
    }

    @Override
    public void deletePublisher(Long publisherId) {
        publisherRepository.deleteById(publisherId);
    }



}
