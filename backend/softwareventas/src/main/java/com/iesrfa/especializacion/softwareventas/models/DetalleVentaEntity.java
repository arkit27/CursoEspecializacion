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
@Table(name = "tb_detalleVenta")
public class DetalleVentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_detalle_venta", nullable = false)
    private UUID id_detalle_venta;
    @Column(name =  "cantidad", nullable = false)
    private int cantidad;
    @Column(name =  "precio_unitario", nullable = false)
    private double precio_unitario;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuariosEntity usuarios;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private UsuariosEntity id_producto;

    @ManyToOne
    @JoinColumn(name = "idVenta")
    private UsuariosEntity id_venta;
}
