package com.iesrfa.especializacion.softwareventas.services.repository;
import com.iesrfa.especializacion.softwareventas.models.MenusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.persistence.Tuple;
import java.util.List;
import java.util.UUID;
@Repository
public interface MenusRepository extends JpaRepository<MenusEntity, UUID> {
    @Query("SELECT m.id as id, m.nombre as nombre, m.url as url, " +
            "m.icono as icono, m.orden as orden, " +
            "m.menuPadre as menuPadre, " +
            "mp.nombre as nombreMenuPadre " +
            "FROM MenusEntity m LEFT JOIN " +
            "MenusEntity mp ON m.menuPadre=mp.id")
    List<Tuple> finAllMenuPadres();

    @Query("SELECT m.id as id, m.nombre as nombre, m.url as url, " +
            "m.icono as icono, m.orden as orden, " +
            "m.menuPadre as menuPadre, " +
            "mp.nombre as nombreMenuPadre " +
            "FROM MenusEntity m LEFT JOIN " +
            "MenusEntity mp ON m.menuPadre=mp.id WHERE m.nombre=?1")
    List<Tuple> finAllMenuPadressearch(String p1);

    @Query("SELECT m.id as id, m.nombre as nombre, m.url as url, " +
            "m.icono as icono, m.orden as orden, " +
            "m.menuPadre as menuPadre, " +
            "mp.nombre as nombreMenuPadre " +
            "FROM MenusEntity m LEFT JOIN " +
            "MenusEntity mp ON m.menuPadre=mp.id WHERE m.nombre=:p1")
    List<Tuple> finAllMenuPadressearch1(String p1);

    @Query("SELECT m.id as id, m.nombre as nombre, m.url as url, " +
            "m.icono as icono, m.orden as orden, " +
            "m.menuPadre as menuPadre, " +
            "mp.nombre as nombreMenuPadre " +
            "FROM MenusEntity m LEFT JOIN " +
            "MenusEntity mp ON m.menuPadre=mp.id WHERE m.nombre=:p1 AND m.orden=:p2")
    List<Tuple> finAllMenuPadressearchAND(String p2, String p1);

    @Query("SELECT m.id as id, m.nombre as nombre, m.url as url, " +
            "m.icono as icono, m.orden as orden, " +
            "m.menuPadre as menuPadre, " +
            "mp.nombre as nombreMenuPadre " +
            "FROM MenusEntity m LEFT JOIN " +
            "MenusEntity mp ON m.menuPadre=mp.id " +
            " WHERE lower(m.nombre) LIKE ?1%  ")
    List<Tuple> finAllMenuPadressearch0(String nombre);

    //Object findByOrden(String param, String param1);
}