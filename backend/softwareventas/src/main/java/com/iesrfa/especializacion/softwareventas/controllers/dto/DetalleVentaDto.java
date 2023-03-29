package com.iesrfa.especializacion.softwareventas.controllers.dto;
import lombok.Data;

import java.util.UUID;
@Data
public class DetalleVentaDto {
    private UUID id_detalle_venta=null;
    private UUID id_venta;
    private UUID id_producto;
    private int cantidad;
    private double precio_unitario;
    private UUID id_empleado ;
}

