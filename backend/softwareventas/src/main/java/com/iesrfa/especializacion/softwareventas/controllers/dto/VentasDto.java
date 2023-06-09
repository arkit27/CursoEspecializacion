package com.iesrfa.especializacion.softwareventas.controllers.dto;
import lombok.Data;

import java.util.Date;
import java.util.UUID;
@Data
public class VentasDto {
    private UUID id_venta=null;
    private String fecha_venta;
    private UUID id_cliente;
    private UUID id_factu;
    private String id_clienteNombres;
    private String id_factuFacturacion;
}
