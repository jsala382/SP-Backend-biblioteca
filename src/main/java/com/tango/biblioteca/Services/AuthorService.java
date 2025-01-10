package com.tango.biblioteca.Services;

import com.tango.biblioteca.domain.dto.AuthorDTO;

import java.util.*;

public interface AuthorService {
    List<AuthorDTO> listarTodo();

    void saveAuthor(AuthorDTO authorDTO);

    List<AuthorDTO> listBookAuthors(String nameAuthor);


}
