package com.example.Book.Store.Api.dto;

import com.example.Book.Store.Api.model.Author;
import com.example.Book.Store.Api.model.Publisher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
  private Long id;
  private String name;

  private Long authorId;
  private Long publisherId;

}
