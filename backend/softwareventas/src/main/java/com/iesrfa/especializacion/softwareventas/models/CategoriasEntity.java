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
@Table(name = "tb_categorias")
public class CategoriasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_categoria", nullable = false)
    private UUID id_categoria;
    @Column(name = "categoria", nullable = false)
    private String categoria;
    @ManyToOne
    @JoinColumn(name = "idproducto")
    private ProductosEntity producto;

}
