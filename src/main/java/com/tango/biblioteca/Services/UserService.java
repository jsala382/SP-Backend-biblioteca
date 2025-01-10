package com.tango.biblioteca.Services;

import com.tango.biblioteca.domain.dto.UserLibraryDTO;

import java.util.*;


public interface UserService {
    public List<UserLibraryDTO> listarUsuario();

    public void saveUser(UserLibraryDTO userDTO);
}
