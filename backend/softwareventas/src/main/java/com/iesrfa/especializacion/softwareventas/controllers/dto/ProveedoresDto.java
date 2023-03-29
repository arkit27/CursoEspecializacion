package com.iesrfa.especializacion.softwareventas.controllers.dto;
import lombok.Data;

import javax.persistence.Column;
import java.util.UUID;
@Data
public class ProveedoresDto {
    private UUID id_proveedor=null;
    private String nombres;
    private String dni;
    private String email;
    private String telefono;
    private String direccion;
}
