package com.tango.biblioteca.controller;

import com.tango.biblioteca.Services.LoanBookService;
import com.tango.biblioteca.domain.dto.LoanBookDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/registrarPrestamos")
public class LoanBookController {
    private final LoanBookService loanBookService;

    @PostMapping
    public void save (@RequestBody LoanBookDTO loanBookDTO){
        loanBookService.saveLoanBook(loanBookDTO);
    }
}
