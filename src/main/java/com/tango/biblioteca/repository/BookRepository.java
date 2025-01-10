package com.tango.biblioteca.repository;

import com.tango.biblioteca.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
