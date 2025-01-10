package com.tango.biblioteca.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tango.biblioteca.domain.entity.Book;
import com.tango.biblioteca.domain.entity.UserLibrary;
import lombok.Data;
import org.hibernate.bytecode.internal.bytebuddy.BytecodeProviderImpl;

import java.time.LocalDate;

@Data
public class LoanBookDTO {
    private int idUser;
    private int idBook;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDelivery;
    private LocalDate dateDevolution;
}
