package com.tango.biblioteca.controller;


import com.tango.biblioteca.Services.UserService;
import com.tango.biblioteca.domain.dto.UserLibraryDTO;
import com.tango.biblioteca.domain.entity.UserLibrary;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/usuario")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserLibraryDTO>  listUser(){
        return userService.listarUsuario();
    }

    @PostMapping("/guardarUsuario")
    public void saveAuthor(@RequestBody UserLibraryDTO userLibraryDTO){
        userService.saveUser(userLibraryDTO);
    }
}
