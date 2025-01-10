package com.tango.biblioteca.domain.dto;

import com.tango.biblioteca.domain.entity.Book;
import lombok.Data;

import java.util.Set;

@Data
public class AuthorDTO {
    private String name;
    private Set<BookDTO> books;

}
