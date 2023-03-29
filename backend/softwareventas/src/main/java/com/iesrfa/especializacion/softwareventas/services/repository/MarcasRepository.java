package com.iesrfa.especializacion.softwareventas.services.repository;

import com.iesrfa.especializacion.softwareventas.models.MarcasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MarcasRepository extends JpaRepository<MarcasEntity, UUID>{
    //MarcasEntity findByMarcas(String marca);
}