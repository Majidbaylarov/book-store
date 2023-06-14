package com.example.Book.Store.Api.service.impl;

import com.example.Book.Store.Api.dto.PublisherDto;
import com.example.Book.Store.Api.dto.UserDto;
import com.example.Book.Store.Api.mapper.BookMapper;
import com.example.Book.Store.Api.mapper.PublisherMapper;
import com.example.Book.Store.Api.mapper.UserMapper;
import com.example.Book.Store.Api.model.Book;
import com.example.Book.Store.Api.model.Publisher;
import com.example.Book.Store.Api.model.User;
import com.example.Book.Store.Api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@Service
//public class UserServiceImpl implements UserService {
//
//
//    private final UserRepository userRepository;
//
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDto addUser(UserDto userDto) {
//        User user = UserMapper.MAPPER.mapToUser(userDto);
//        User addedUser = userRepository.save(user);
//        UserDto userDtos = UserMapper.MAPPER.mapToUserDto(user);
//        return userDtos;
//    }
//
//    @Override
//    public UserDto getUserById(Long userId) {
//        Optional<User> optionalUser=userRepository.findById(userId);
//        User user=optionalUser.get();
//        return UserMapper.MAPPER.mapToUserDto(optionalUser.get());
//    }
//
//    @Override
//    public List<UserDto> getAllUsers() {
//        List<User> users = userRepository.findAll();
//        return users.stream().map((user) -> UserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());
//    }
//
//    @Override
//    public UserDto updateUser(UserDto userDto) {
//        User existingUser=userRepository.findById(userDto.getId()).get();
//        existingUser.setName(userDto.getName());
//        existingUser.setId(userDto.getId());
//        existingUser.setSurname(userDto.getSurname());
//        existingUser.setEmail(userDto.getEmail());
//        User updatedUser=userRepository.save(existingUser);
//        return UserMapper.MAPPER.mapToUserDto(updatedUser);
//    }
//
//    @Override
//    public void deleteUser(Long userId) {
//        userRepository.deleteById(userId);
//
//    }
//}
