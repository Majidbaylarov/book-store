package com.example.Book.Store.Api.mapper;

import com.example.Book.Store.Api.dto.BookDto;
import com.example.Book.Store.Api.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper MAPPER = Mappers.getMapper(BookMapper.class);

    @Mappings({
            @Mapping(target = "authorId", source = "author.id"),
            @Mapping(target = "publisherId", source = "publisher.id")
    }
    )
    BookDto mapToBookDto(Book book);

    @Mapping(target = "author.id", source = "authorId")
    @Mapping(target = "publisher.id", source = "publisherId")
    Book mapToBook(BookDto bookDto);


}
