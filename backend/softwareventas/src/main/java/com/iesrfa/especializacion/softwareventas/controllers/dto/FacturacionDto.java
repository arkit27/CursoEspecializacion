package com.iesrfa.especializacion.softwareventas.controllers.dto;
import lombok.Data;

import java.util.UUID;
@Data
public class FacturacionDto {
    private UUID id_factu=null;
    private String facturacion; // boleta o factura
}
