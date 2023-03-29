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
@Table(name = "tb_usuarios")
public class UsuariosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUsuario", nullable = false)
    private UUID id;
    @Column(name = "usuario", nullable = false)
    private String user;
    @Column(name = "clave", nullable = false)
    private String password;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "rol", nullable = false)
    private String rol;

}
