package com.tango.biblioteca.Services.impl;

import com.tango.biblioteca.Services.UserService;
import com.tango.biblioteca.domain.dto.AuthorDTO;
import com.tango.biblioteca.domain.dto.BookDTO;
import com.tango.biblioteca.domain.dto.UserLibraryDTO;
import com.tango.biblioteca.domain.entity.UserLibrary;
import com.tango.biblioteca.repository.UserLibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserLibraryRepository userLibraryRepository;
    @Override
    public List<UserLibraryDTO> listarUsuario() {
        List<UserLibrary> userList=userLibraryRepository.findAll();
        ArrayList<UserLibraryDTO> userLibraryDTOS=new ArrayList<>();
        for(UserLibrary userLibrary : userList){
            UserLibraryDTO userLibrary1DTO=new UserLibraryDTO();
            userLibrary1DTO.setName(userLibrary.getName());
            userLibrary1DTO.setAddress(userLibrary.getAddress());
            userLibrary1DTO.setPhoneNumber(userLibrary.getPhoneNumber());
            Set<BookDTO> bookDTOS = userLibrary.getBooks().stream().map( book-> {
                BookDTO bookDTO=new BookDTO();
                bookDTO.setTittle(book.getTittle());
                bookDTO.setIsbn(bookDTO.getIsbn());
                bookDTO.setYearEdition(bookDTO.getYearEdition());
                return bookDTO;
            }).collect(Collectors.toSet());
            userLibrary1DTO.setBooks(bookDTOS);
            userLibraryDTOS.add(userLibrary1DTO);
        }
        return userLibraryDTOS;
    }

    @Override
    public void saveUser(UserLibraryDTO userDTO) {
        UserLibrary userLibrary=new UserLibrary();
        userLibrary.setName(userDTO.getName());
        userLibrary.setAddress(userDTO.getAddress());
        userLibrary.setPhoneNumber(userDTO.getPhoneNumber());
        userLibraryRepository.save(userLibrary);

    }
}
