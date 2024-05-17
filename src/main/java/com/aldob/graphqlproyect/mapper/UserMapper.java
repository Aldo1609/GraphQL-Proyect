package com.aldob.graphqlproyect.mapper;

import com.aldob.graphqlproyect.entity.UserEntity;
import com.aldob.graphqlproyect.model.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setUsuario(userEntity.getUsuario());
        userDTO.setCorreo(userEntity.getCorreo());
        userDTO.setContrasena(userEntity.getContrasena());
        userDTO.setRol(userEntity.getRol());
        return userDTO;
    }

    public UserEntity toEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setUsuario(userDTO.getUsuario());
        userEntity.setCorreo(userDTO.getCorreo());
        userEntity.setContrasena(userDTO.getContrasena());
        userEntity.setRol(userDTO.getRol());
        return userEntity;
    }

}
