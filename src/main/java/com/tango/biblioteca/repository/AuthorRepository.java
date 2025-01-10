package com.tango.biblioteca.repository;

import com.tango.biblioteca.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
