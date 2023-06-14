package com.example.Book.Store.Api.mapper;

import com.example.Book.Store.Api.dto.AuthorDto;
import com.example.Book.Store.Api.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {

  AuthorMapper MAPPER= Mappers.getMapper(AuthorMapper.class);
    AuthorDto mapToAuthorDto(Author author);
    Author mapToAuthor(AuthorDto authorDto);
}
