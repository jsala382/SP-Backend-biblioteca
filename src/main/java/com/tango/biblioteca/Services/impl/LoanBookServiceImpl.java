package com.tango.biblioteca.Services.impl;

import com.tango.biblioteca.Services.LoanBookService;
import com.tango.biblioteca.domain.dto.BookDTO;
import com.tango.biblioteca.domain.dto.LoanBookDTO;
import com.tango.biblioteca.domain.entity.Book;
import com.tango.biblioteca.domain.entity.LoanBook;
import com.tango.biblioteca.domain.entity.UserLibrary;
import com.tango.biblioteca.repository.BookRepository;
import com.tango.biblioteca.repository.LoanBookRepository;
import com.tango.biblioteca.repository.UserLibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanBookServiceImpl  implements LoanBookService {

    private final LoanBookRepository loanBookRepository;
    private final BookRepository bookRepository;
    private final UserLibraryRepository userLibraryRepository;
    @Override
    public void saveLoanBook(LoanBookDTO loanBookDTO) {
        LoanBook loanBook=new LoanBook();
        Optional<Book> book=bookRepository.findById(loanBookDTO.getIdBook());
        Optional<UserLibrary> userLibrary=userLibraryRepository.findById(loanBookDTO.getIdUser());
        if(book.isEmpty() && userLibrary.isEmpty()){
            throw new RuntimeException("El libro o el codigo no existe");
        }
        loanBook.setIdUser(userLibrary.get());
        loanBook.setIdBook(book.get());
        loanBook.setDateDelivery(loanBookDTO.getDateDelivery());
        loanBook.setDateDevoluction(loanBookDTO.getDateDevolution());
        loanBookRepository.save(loanBook);

    }
}
