//package com.example.Book.Store.Api.controller;
//
//import com.example.Book.Store.Api.dto.BookDto;
//import com.example.Book.Store.Api.dto.PublisherDto;
//import com.example.Book.Store.Api.dto.UserDto;
//import com.example.Book.Store.Api.service.UserService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/user")
//public class UserController {
//
//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping
//    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
//        UserDto savedUser = userService.addUser(userDto);
//        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
//        UserDto user = userService.getUserById(userId);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<UserDto>> getAllPublishers() {
//        List<UserDto> user = userService.getAllUsers();
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @DeleteMapping ("{id}")
//    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
//        userService.deleteUser(userId);
//        return new ResponseEntity<>("User succesfully deleted!", HttpStatus.OK);
//    }
//
//    @PutMapping("/")
//    public ResponseEntity<UserDto> updateBook(@RequestBody UserDto userDto){
//        UserDto userDtos=userService.updateUser(userDto);
//        return ResponseEntity.ok().body(userDtos);
//    }
//
//
//}
