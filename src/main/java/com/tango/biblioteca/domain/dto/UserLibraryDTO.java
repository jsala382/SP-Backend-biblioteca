package com.tango.biblioteca.domain.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserLibraryDTO {
    private String name;
    private String address;
    private String phoneNumber;
    private Set<BookDTO> books;
}
