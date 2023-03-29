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
@Table(name = "tb_marcas")
public class MarcasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_marca", nullable = false)
    private UUID id_marca;
    @Column(name = "marca", nullable = false)
    private String marca;
    @ManyToOne
    @JoinColumn(name = "idproducto")
    private ProductosEntity producto;
}
