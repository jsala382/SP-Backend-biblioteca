package com.tango.biblioteca.Services.impl;

import com.tango.biblioteca.domain.dto.AuthorDTO;
import com.tango.biblioteca.domain.dto.BookDTO;
import com.tango.biblioteca.domain.entity.Author;
import com.tango.biblioteca.domain.entity.Book;
import com.tango.biblioteca.repository.AuthorRepository;
import com.tango.biblioteca.repository.BookRepository;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements com.tango.biblioteca.Services.BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public List<BookDTO> listarTodo() {
        List<Book> bookList = bookRepository.findAll();
        ArrayList<BookDTO> bookDTOArrayList = new ArrayList<>();
        for (Book book : bookList) {
            BookDTO bookDTOA = new BookDTO();
            bookDTOA.setTittle(book.getTittle());
            bookDTOA.setIsbn(book.getIsbn());
            bookDTOA.setYearEdition(book.getYearEdition());
            bookDTOArrayList.add(bookDTOA);
        }
        return bookDTOArrayList;
    }

    //-------------------------------------------------------------------------------------------------------
    @Override
    public void saveBook(BookDTO bookDTO) {
        List<Book> bookList = bookRepository.findAll();
        boolean flag = false;
        for (Book book : bookList) {
            if (bookDTO.getIsbn().equals(book.getIsbn())) {
                flag = true;
            }
        }
        if (flag) {
            System.out.println("Ya existe el libro");
        } else {
            Book book = new Book();
            book.setTittle(bookDTO.getTittle());
            book.setIsbn(bookDTO.getIsbn());
            book.setYearEdition(bookDTO.getYearEdition());
            bookRepository.save(book);
        }
    }

    //-----------------------------------------------------------------------------------------------
    @Override
    public void assignBookAuthor(int idLibros, List<Integer> idAuthors) {
        Optional<Book> book = bookRepository.findById(idLibros);
        if (!(book.isPresent())) {
            System.out.println("El libro  no esta presente");
        }
        List<Author> authorList = authorRepository.findAllById(idAuthors);
        if (authorList.isEmpty()) {
            System.out.println("Los autores no existen");
        }
        Book book1 = book.get();
        for (Author authors : authorList) {
            book1.getAutores().add(authors);
        }
        bookRepository.save(book1);
    }

    //------------------------------------------------------------------------------------------

    @Override
    public List<BookDTO> filterBookByYearEdition(int yearsEdition) {
      return bookRepository.findAll().stream().filter(book -> book.getYearEdition() == yearsEdition).map(book -> {
            BookDTO book1 = new BookDTO();
            book1.setTittle(book.getTittle());
            book1.setIsbn(book.getIsbn());
            book1.setYearEdition(book.getYearEdition());
            return book1;
        }).collect(Collectors.toList());
    }


}
