package com.iesrfa.especializacion.softwareventas.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_ventas")
public class VentasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_venta", nullable = false)
    private UUID id_venta;
    @Column(name = "fecha_venta", nullable = false)
    private Date fecha_venta;
    @ManyToOne
    @JoinColumn(name = "id_detalle_venta")
    private DetalleVentaEntity id_detalle_venta;

}
