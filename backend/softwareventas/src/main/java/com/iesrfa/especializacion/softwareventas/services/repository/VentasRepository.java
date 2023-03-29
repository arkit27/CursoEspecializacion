package com.iesrfa.especializacion.softwareventas.services.repository;
import com.iesrfa.especializacion.softwareventas.models.VentasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
@Repository
public interface VentasRepository extends JpaRepository<VentasEntity, UUID>{
    //List<VentasEntity> findByVentaId(UUID id_venta);
}