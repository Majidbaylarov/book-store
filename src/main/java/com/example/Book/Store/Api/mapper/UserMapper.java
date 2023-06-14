package com.example.Book.Store.Api.mapper;

import com.example.Book.Store.Api.dto.UserDto;
import com.example.Book.Store.Api.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper MAPPER= Mappers.getMapper(UserMapper.class);

    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);
}
