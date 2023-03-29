package com.iesrfa.especializacion.softwareventas.controllers.dto;
import lombok.Data;
import java.util.UUID;
@Data
public class ClientesDto {
    private UUID id_cliente;
    private String dni;
    private String nombre;
    private String apellido ;
    private String email;
    private String telefono;
    private String direccion;
}
