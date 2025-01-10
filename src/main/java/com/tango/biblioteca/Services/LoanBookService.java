package com.tango.biblioteca.Services;

import com.tango.biblioteca.domain.dto.LoanBookDTO;
import com.tango.biblioteca.domain.dto.UserLibraryDTO;

import java.time.LocalDate;

public interface LoanBookService {
    public void saveLoanBook(LoanBookDTO loanBookDTO);
    public String  filterLoanByDate(int id);
    public UserLibraryDTO filteruserByBook(String name);
}
