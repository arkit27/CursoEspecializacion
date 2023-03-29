package com.iesrfa.especializacion.softwareventas.services.repository;

import com.iesrfa.especializacion.softwareventas.models.FacturacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface FacturacionRepository extends JpaRepository<FacturacionEntity, UUID>{
    //FacturacionEntity findByFacturacion(String facturacion);
}