package com.iesrfa.especializacion.softwareventas.services;
import com.iesrfa.especializacion.softwareventas.controllers.dto.MenuDto;
import com.iesrfa.especializacion.softwareventas.models.MenusEntity;
import com.iesrfa.especializacion.softwareventas.services.repository.MenusRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.InheritanceType;
import javax.persistence.Tuple;
import java.util.*;
import java.util.stream.Collectors;
@Service
@Slf4j
public class MenusService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    MenusRepository repository;
    public List<MenuDto> getAll(){
        try{
            return repository.findAll()
                    .stream()
                    .map(x->modelMapper.map(x,MenuDto.class))
                    .collect(Collectors.toList());
        }catch(Exception ex){
            return null;
        }
    }

    public List<MenuDto> getAllConMenuPadres(){
        try{
            var datos=repository.finAllMenuPadres();
            return this.lista(datos);
        }catch(Exception ex){
            log.error("Error al listar Menus : ",ex.getMessage());
            return null;
        }
    }

    public List<MenuDto> finAllMenuPadressearch0(String nombre){
        try{
            var datos=repository.finAllMenuPadressearch0(nombre.toLowerCase());
            return this.lista(datos);
        }catch(Exception ex){
            log.error("Error al listar Menus : ",ex.getMessage());
            return null;
        }
    }
    private List<MenuDto> lista(List<Tuple> datos){
        List<MenuDto> lista = new ArrayList<>();
        for (Tuple ele : datos){
            MenuDto dtotmp=new MenuDto();
            dtotmp.setId((UUID) ele.get("id"));
            dtotmp.setNombre((String) ele.get("nombre"));
            dtotmp.setIcono((String) ele.get("icono"));
            dtotmp.setOrden((Integer) ele.get("orden"));
            dtotmp.setUrl((String) ele.get("url"));
            dtotmp.setMenuPadre((UUID) ele.get("menuPadre"));
            dtotmp.setNombrePadre((String) ele.get("nombreMenuPadre"));
            lista.add(dtotmp);
        }
        return  lista;
    }

    /*public MenuDto getOrden(Integer orden ,String nombre) {
        try {
            String[] params = {nombre};
            Arrays.sort(params, (a, b) -> {
                if (orden.equals("asc")) {
                    return a.compareTo(b);
                } else if (orden.equals("desc")) {
                    return b.compareTo(a);
                } else {
                    return 0;
                }
            });
            return this.modelMapper.map(
                    repository.findByOrden(params[0], params[1]),
                    MenuDto.class
            );
        } catch (Exception ex) {
            return null;
        }
    }*/


    public MenuDto save(MenuDto registro){
        try{
            return  this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registro, MenusEntity.class)
                    ),MenuDto.class);
        }catch(Exception ex){
            return null;
        }
    }
    public Boolean delete(UUID id){
        try{
            Optional<MenusEntity> registro=
                    repository.findById(id);
            if(registro.isPresent()){
                repository.delete(registro.get());
                return true;
            }
            return false;
        }catch(Exception ex){
            return false;
        }
    }

}
