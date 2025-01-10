package com.tango.biblioteca.controller;


import com.tango.biblioteca.Services.impl.AuthorServiceImpl;
import com.tango.biblioteca.domain.dto.AuthorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/autores")
public class AuthorController {
    private final AuthorServiceImpl authorService;

    @GetMapping("/all")
    public List<AuthorDTO> getListAuthor(){
        return authorService.listarTodo();
    }

    @PostMapping
    public void save(@RequestBody AuthorDTO authorDTO){
        authorService.saveAuthor(authorDTO);
    }

    @GetMapping("/listar")
    public List<AuthorDTO> FilterAuthorByBook(@RequestParam String nameAuthor){
        return authorService.listBookAuthors(nameAuthor);
    }
}
