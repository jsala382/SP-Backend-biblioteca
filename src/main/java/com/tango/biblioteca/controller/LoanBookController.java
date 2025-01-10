package com.tango.biblioteca.controller;

import com.tango.biblioteca.Services.LoanBookService;
import com.tango.biblioteca.domain.dto.LoanBookDTO;
import com.tango.biblioteca.domain.dto.UserLibraryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/registrarPrestamos")
public class LoanBookController {
    private final LoanBookService loanBookService;

    @PostMapping
    public void save (@RequestBody LoanBookDTO loanBookDTO){
        loanBookService.saveLoanBook(loanBookDTO);
    }
    @GetMapping("/status")
    public ResponseEntity <String> dateDevolution(@RequestParam int id){
       String status= loanBookService.filterLoanByDate(id);
       return ResponseEntity.ok(status);
    }

    @GetMapping("/filtrar-prestamo-usuario")
    public UserLibraryDTO filterBookuSER(@RequestParam String  name){
       return loanBookService.filteruserByBook(name);
    }

}
