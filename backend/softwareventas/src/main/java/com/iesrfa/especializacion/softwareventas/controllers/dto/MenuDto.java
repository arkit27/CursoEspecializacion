package com.iesrfa.especializacion.softwareventas.controllers.dto;
import lombok.Data;

import java.util.UUID;
@Data
public class MenuDto {
    private UUID id;
    private String nombre;
    private String url;
    private String icono;
    private Integer orden;
    private UUID menuPadre=null;
    private String nombrePadre=null;

}
