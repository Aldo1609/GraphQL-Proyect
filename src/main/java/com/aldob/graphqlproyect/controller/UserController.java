package com.aldob.graphqlproyect.controller;

import com.aldob.graphqlproyect.model.UserDTO;
import com.aldob.graphqlproyect.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @QueryMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public UserDTO findById(@Argument Long id) {
        return userService.findById(id);
    }

    @MutationMapping
    public UserDTO createUser(@Argument String usuario, @Argument String correo, @Argument String contrasena, @Argument String rol) {
        return userService.createUser(usuario, correo, contrasena, rol);
    }

    @MutationMapping
    public UserDTO updateUser(@Argument Long id, @Argument String usuario, @Argument String correo, @Argument String contrasena, @Argument String rol) {
        return userService.updateUser(id, usuario, correo, contrasena, rol);
    }

    @MutationMapping
    public void deleteUser(@Argument Long id) {
       userService.deleteUser(id);
    }

}
