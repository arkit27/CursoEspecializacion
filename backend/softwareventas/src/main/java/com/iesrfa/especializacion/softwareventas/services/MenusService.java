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

    private List<MenuDto> listaBusca(List<Tuple> datosb){
        List<MenuDto> listaB = new ArrayList<>();
        for (Tuple eles : datosb) {
            MenuDto dtotmps = new MenuDto();
            dtotmps.setId(eles.get("id") == null ? null : (UUID) eles.get("ID"));
            dtotmps.setNombre(eles.get("nombre") == null ? null : (String) eles.get("nombre"));
            dtotmps.setIcono(eles.get("icono") == null ? null : (String) eles.get("icono"));
            dtotmps.setOrden(eles.get("orden") == null ? null : (Integer) eles.get("orden"));
            dtotmps.setUrl(eles.get("url") == null ? null : (String) eles.get("url"));
            dtotmps.setMenuPadre(eles.get("menuPadre") == null ? null : (UUID) eles.get("menuPadre"));
            dtotmps.setNombrePadre(eles.get("nombreMenuPadre") == null ? null : (String) eles.get("nombreMenuPadre"));
            listaB.add(dtotmps);
        }
        return listaB;
    }


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
