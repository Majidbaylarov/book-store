package com.example.Book.Store.Api.mapper;

import com.example.Book.Store.Api.dto.PublisherDto;
import com.example.Book.Store.Api.model.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublisherMapper {

    PublisherMapper MAPPER= Mappers.getMapper(PublisherMapper.class);
    //@Mapping(target = "bookId", source = "book.id")
    PublisherDto mapToPublisherDto(Publisher publisher);
    Publisher mapToPublisher(PublisherDto publisherDto);
}
