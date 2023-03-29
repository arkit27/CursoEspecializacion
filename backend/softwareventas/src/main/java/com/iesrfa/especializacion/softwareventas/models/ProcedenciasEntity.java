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
@Table(name = "tb_procendencias")
public class ProcedenciasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_procedencia", nullable = false)
    private UUID id_procedencia;
    @Column(name = "procedencia", nullable = false)
    private String procedencia ;
    @ManyToOne
    @JoinColumn(name = "idproducto")
    private ProductosEntity producto;

}
