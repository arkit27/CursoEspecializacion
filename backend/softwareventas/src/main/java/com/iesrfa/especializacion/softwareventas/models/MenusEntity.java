package com.iesrfa.especializacion.softwareventas.models;
import lombok.*;
import javax.persistence.*;
import java.util.UUID;
@Entity
@Table(name="tbMenus")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idMenu", nullable = false)
    private UUID id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "url", nullable = false)
    private String url;
    @Column(name = "icono", nullable = false)
    private String icono;
    @Column(name = "orden", nullable = false)
    private Integer orden;
    @Column(name = "menu_padre", nullable = true)
    private UUID menuPadre;
}
