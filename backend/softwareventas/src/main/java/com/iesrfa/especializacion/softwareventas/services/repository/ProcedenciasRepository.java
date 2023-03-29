package com.iesrfa.especializacion.softwareventas.services.repository;

import com.iesrfa.especializacion.softwareventas.models.MarcasEntity;
import com.iesrfa.especializacion.softwareventas.models.ProcedenciasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ProcedenciasRepository extends JpaRepository<ProcedenciasEntity, UUID> {
    //ProcedenciasEntity findByProcedencia(String procedencia);
}