package com.tango.biblioteca.Services.impl;

import com.tango.biblioteca.Services.LoanBookService;
import com.tango.biblioteca.domain.dto.BookDTO;
import com.tango.biblioteca.domain.dto.LoanBookDTO;
import com.tango.biblioteca.domain.dto.UserLibraryDTO;
import com.tango.biblioteca.domain.entity.Book;
import com.tango.biblioteca.domain.entity.LoanBook;
import com.tango.biblioteca.domain.entity.UserLibrary;
import com.tango.biblioteca.repository.BookRepository;
import com.tango.biblioteca.repository.LoanBookRepository;
import com.tango.biblioteca.repository.UserLibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Override
    public String filterLoanByDate(int idLoan) {
        Optional<LoanBook> loanBook1=   loanBookRepository.findById(idLoan);
        LoanBook loanBook2= loanBook1.get();
        String entrega;
        if(loanBook1.isEmpty()){
            throw new RuntimeException("No se encontro esa fecha de devolucion");
        }else{
            LocalDate current=LocalDate.now();
            boolean currentDay=current.isBefore(loanBook2.getDateDevoluction()) || current.equals(loanBook2.getDateDevoluction());
            entrega= currentDay? "Devolver Libro": "Atrasado";
        }

        return entrega;
    }

    @Override
    public UserLibraryDTO filteruserByBook(String name) {
       Optional<UserLibrary> userLibrary1 = userLibraryRepository.findAll().stream().filter(userLibrary -> userLibrary.getName().equals(name)).findFirst();
       UserLibrary userLibraryGet=userLibrary1.get();
       if(userLibrary1.isEmpty()) {
           throw new RuntimeException("No existe el usuario");
       }else{
           UserLibraryDTO userLibraryDTO = new UserLibraryDTO();
           userLibraryDTO.setName(userLibraryGet.getName());
           userLibraryDTO.setAddress(userLibraryGet.getAddress());
           userLibraryDTO.setPhoneNumber(userLibraryGet.getPhoneNumber());
           Set<BookDTO> bookDTOSet = userLibraryGet.getBooks().stream().map(book -> {
               BookDTO bookDTO = new BookDTO();
               bookDTO.setTittle(book.getTittle());
               return bookDTO;
           }).collect(Collectors.toSet());
           userLibraryDTO.setBooks(bookDTOSet);
           return userLibraryDTO;
       }
    }
}
