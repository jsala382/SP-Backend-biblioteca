package com.tango.biblioteca.domain.dto;

import com.tango.biblioteca.domain.entity.Author;
import lombok.Data;

import java.util.Set;

@Data
public class BookDTO {
    private String tittle;
    private String isbn;
    private int yearEdition;
   private Set<AuthorDTO> authors;
    private Set<UserLibraryDTO> users;
}
