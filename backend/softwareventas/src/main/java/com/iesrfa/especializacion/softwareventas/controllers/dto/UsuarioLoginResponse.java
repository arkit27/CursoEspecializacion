package com.iesrfa.especializacion.softwareventas.controllers.dto;

import lombok.Data;

@Data
public class UsuarioLoginResponse {
    private int codigo=200;
    private String mensaje="";
    private String token="";
}