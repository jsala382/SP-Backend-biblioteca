package com.tango.biblioteca.Services;

import com.tango.biblioteca.domain.dto.BookDTO;
import com.tango.biblioteca.domain.entity.Book;

import java.util.*;

public interface BookService {
    List<BookDTO> listarTodo();

    void saveBook(BookDTO bookDTO);

    void assignBookAuthor(int idLibros, List<Integer> idAuthors);

    List<BookDTO> filterBookByYearEdition(int yearEdition);

}
