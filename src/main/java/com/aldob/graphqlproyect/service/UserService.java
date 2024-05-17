package com.aldob.graphqlproyect.service;

import com.aldob.graphqlproyect.model.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO findById(Long id);

    UserDTO createUser(String usuario, String correo, String contrasena, String rol);

    UserDTO updateUser(Long id, String correo, String usuario, String contrasena, String rol);

    void deleteUser(Long id);


}
