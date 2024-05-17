package com.aldob.graphqlproyect.model;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String usuario;
    private String correo;
    private String contrasena;
    private String rol;
}
