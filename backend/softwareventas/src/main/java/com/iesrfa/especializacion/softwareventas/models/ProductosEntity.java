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
    @Column(name = "peso", nullable = false)
    private double peso;
    @ManyToOne
    @JoinColumn(name = "id_marca")
    private MarcasEntity id_marca;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriasEntity id_categoria;
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private ProveedoresEntity id_proveedor;
    @ManyToOne
    @JoinColumn(name = "id_procedencia")
    private ProcedenciasEntity id_procedencia;

}
