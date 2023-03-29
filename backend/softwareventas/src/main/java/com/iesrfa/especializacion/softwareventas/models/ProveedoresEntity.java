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
@Table(name = "tb_proveedores")
public class ProveedoresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_proveedor", nullable = false)
    private UUID id_proveedor;
    @Column(name = "nombres", nullable = false)
    private String nombres;
    @Column(name = "dni", nullable = false)
    private String dni;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "telefono", nullable = false)
    private String telefono;
    @Column(name = "direccion", nullable = false)
    private String direccion;
    @ManyToOne
    @JoinColumn(name = "idproducto")
    private ProductosEntity producto;
}
