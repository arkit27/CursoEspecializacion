package com.iesrfa.especializacion.softwareventas.controllers.dto;
import com.iesrfa.especializacion.softwareventas.models.CategoriasEntity;
import lombok.Data;
import java.util.UUID;
@Data
public class ProductosDto {
    private UUID id_producto=null;
    private String nombre;
    private String descripcion;
    private double precio_unitario;
    private double precio_compra;
    private double precio_venta;
    private int stock;
    private int stockmin;
    private double peso;
    ////
    private UUID id_marca ;
    private UUID id_categoria;
    private UUID id_proveedor;
    private UUID id_procedencia ;
    private String id_marcaMarca;
    private String id_categoriaCategoria;
    private String id_proveedorNombres;
    private String id_procedenciaProcedencia;

}
