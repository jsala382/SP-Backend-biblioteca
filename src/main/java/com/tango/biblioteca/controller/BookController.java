package com.tango.biblioteca.controller;



import com.tango.biblioteca.Services.impl.BookServiceImpl;
import com.tango.biblioteca.domain.dto.BookDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/libros")
public class BookController {
    private final BookServiceImpl bookService;

    @GetMapping("/all")
    public List<BookDTO> getListAuthor(){
        return bookService.listarTodo();
    }

    @PostMapping
    public void save(@RequestBody BookDTO bookDTO){
        bookService.saveBook(bookDTO);
    }

    @PostMapping("/{idLibro}/autores")
    public ResponseEntity<String> assignAuthortoBook(@PathVariable int idLibro, @RequestBody List<Integer> idAuthor){
        try{
            bookService.assignBookAuthor(idLibro,idAuthor);
            return ResponseEntity.ok("Autores asignados");
        }catch (RuntimeException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    @GetMapping("/filter")
    public List<BookDTO> FilterBookYear(@RequestParam int yearEdition ){
        return bookService.filterBookByYearEdition(yearEdition);

    }



}
