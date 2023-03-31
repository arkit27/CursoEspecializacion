package com.iesrfa.especializacion.softwareventas.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_productos")
public class ProductosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_producto", nullable = false)
    private UUID id_producto;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "precio_unitario", nullable = false)
    private double precio_unitario;
    @Column(name = "precio_compra", nullable = false)
    private double precio_compra;
    @Column(name = "precio_venta", nullable = false)
    private double precio_venta;
    @Column(name = "stock", nullable = false)
    private int stock;
    @Column(name = "stockmin", nullable = false)
    private int stockmin;

    @Column(name = "procedencia", nullable = false)
    private String procedencia ;
    @Column(name = "peso", nullable = false)
    private double peso;
    @ManyToOne
    @JoinColumn(name = "idMarca")
    private MarcasEntity idMarca;
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private CategoriasEntity idCategoria;
    @ManyToOne
    @JoinColumn(name = "idProveedor")
    private ProveedoresEntity idProveedor;
    @ManyToOne
    @JoinColumn(name = "idProcedencia")
    private ProcedenciasEntity idProcedencia;

}
