package com.aldob.graphqlproyect.service.impl;

import com.aldob.graphqlproyect.entity.UserEntity;
import com.aldob.graphqlproyect.mapper.UserMapper;
import com.aldob.graphqlproyect.model.UserDTO;
import com.aldob.graphqlproyect.repository.UserRepository;
import com.aldob.graphqlproyect.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO)
                .orElseThrow( () -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public UserDTO createUser(String usuario, String correo, String contrasena, String rol) {
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new IllegalArgumentException("The username cannot be empty");
        }

        if (correo == null || correo.trim().isEmpty()) {
            throw new IllegalArgumentException("The mail cannot be empty");
        }

        if (contrasena == null || contrasena.trim().isEmpty()) {
            throw new IllegalArgumentException("The password cannot be empty");
        }
        if (rol == null || rol.trim().isEmpty()) {
            throw new IllegalArgumentException("The role cannot be empty");
        }

        boolean exists = userRepository.findByUsuario(usuario).isPresent();
        if (exists) {
            throw new IllegalStateException("The username is already taken");
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUsuario(usuario);
        userEntity.setCorreo(correo);
        userEntity.setContrasena(contrasena);
        userEntity.setRol(rol);

        UserEntity savedUser = userRepository.save(userEntity);
        return userMapper.toDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(Long id, String usuario,  String correo, String contrasena, String rol) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        if (usuario != null && !usuario.trim().isEmpty()) {
            userEntity.setUsuario(usuario);
        }
        if (correo != null && !correo.trim().isEmpty()) {
            userEntity.setCorreo(correo);
        }
        if (contrasena != null && !contrasena.trim().isEmpty()) {
            userEntity.setContrasena(contrasena);
        }
        if (rol != null && !rol.trim().isEmpty()) {
            userEntity.setRol(rol);
        }

        UserEntity updatedUser = userRepository.save(userEntity);
        return userMapper.toDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {

        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        userRepository.deleteById(id);
    }
}
