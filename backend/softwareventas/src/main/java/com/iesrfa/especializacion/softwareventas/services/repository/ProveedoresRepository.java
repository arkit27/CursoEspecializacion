package com.iesrfa.especializacion.softwareventas.services.repository;
import com.iesrfa.especializacion.softwareventas.models.ProcedenciasEntity;
import com.iesrfa.especializacion.softwareventas.models.ProveedoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ProveedoresRepository extends JpaRepository<ProveedoresEntity, UUID>{
    //ProveedoresEntity findByNombre(String nombres);
}