package com.iesrfa.especializacion.softwareventas.services.repository;

import com.iesrfa.especializacion.softwareventas.models.DetalleVentaEntity;
import com.iesrfa.especializacion.softwareventas.models.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVentaEntity, UUID>{
    //List<DetalleVentaEntity> findByDetalleVentaId(UUID id_detalle_venta);
}