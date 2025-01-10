package com.tango.biblioteca.repository;

import com.tango.biblioteca.domain.entity.LoanBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanBookRepository extends JpaRepository<LoanBook, Integer> {
}
