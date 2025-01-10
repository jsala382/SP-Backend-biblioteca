package com.tango.biblioteca.repository;

import com.tango.biblioteca.domain.entity.UserLibrary;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLibraryRepository extends JpaRepository<UserLibrary, Integer> {
}
