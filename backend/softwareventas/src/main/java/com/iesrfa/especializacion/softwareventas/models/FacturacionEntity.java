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
@Table(name = "tb_facturacion")
public class FacturacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_factu", nullable = false)
    private UUID id_factu;
    @Column(name = "facturacion", nullable = false)
    private String facturacion; // boleta o factura
    @OneToOne//nombre de la relacion
    @JoinColumn(name="idventas")
    private VentasEntity venta;
}
