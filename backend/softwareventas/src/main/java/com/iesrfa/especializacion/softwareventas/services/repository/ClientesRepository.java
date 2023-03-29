package com.iesrfa.especializacion.softwareventas.services.repository;

import com.iesrfa.especializacion.softwareventas.models.CategoriasEntity;
import com.iesrfa.especializacion.softwareventas.models.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ClientesRepository extends JpaRepository<ClientesEntity, UUID>{
    //ClientesEntity findByNombre(String nombre);
}