package com.iesrfa.especializacion.softwareventas.controllers.dto;
import lombok.Data;
import java.util.UUID;
@Data
public class UsuariosDto {
    private UUID id;
    private String user;

    private String password;

    private String nombre;

    private String rol;

    private boolean rescribirclave=false;

}
