package com.tango.biblioteca.Services.impl;

import com.tango.biblioteca.Services.AuthorService;
import com.tango.biblioteca.domain.dto.AuthorDTO;
import com.tango.biblioteca.domain.dto.BookDTO;
import com.tango.biblioteca.domain.entity.Author;
import com.tango.biblioteca.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<AuthorDTO> listarTodo() {
        List<Author> authorList = authorRepository.findAll();
        List<AuthorDTO> authorDTOList = new ArrayList<>();
        for (Author author : authorList) {
            AuthorDTO authorDTO = new AuthorDTO();
            authorDTO.setName(author.getName());
            authorDTOList.add(authorDTO);
        }
        return authorDTOList;
    }

    @Override
    public void saveAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.getName());
        authorRepository.save(author);
    }

    @Override
    public List<AuthorDTO> listBookAuthors(String nameAuthor) {
        List<Author> authors = authorRepository.findAll().stream().filter(author -> author.getName().contains(nameAuthor))
                .collect(Collectors.toList());
        if (authors.isEmpty()) {
            System.out.println(" No existe el autor ");
        }
        return authors.stream().map(author -> {

            AuthorDTO authorDTO = new AuthorDTO();
            authorDTO.setName(author.getName());
            Set<BookDTO> bookDTOSet = author.getBook().stream().map(book -> {
                BookDTO bookDTO = new BookDTO();
                bookDTO.setTittle(book.getTittle());
                bookDTO.setIsbn(book.getIsbn());
                bookDTO.setYearEdition(book.getYearEdition());
                return bookDTO;
            }).collect(Collectors.toSet());
            authorDTO.setBooks(bookDTOSet);
            return authorDTO;
        }).collect(Collectors.toList());
    }


}
