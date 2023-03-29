package com.iesrfa.especializacion.softwareventas.services.repository;
import com.iesrfa.especializacion.softwareventas.models.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosEntity, UUID> {
    //List<UsuariosEntity> findByEmpleadoIdEmpleado(UUID id_empleado);
    @Query("SELECT u FROM UsuariosEntity u WHERE u.user=?1 AND u.password=?2")
    UsuariosEntity login(String usuario, String clave);
    UsuariosEntity findByUser(String usuario);
    UsuariosEntity findByUserAndPassword(String user, String clave);


}