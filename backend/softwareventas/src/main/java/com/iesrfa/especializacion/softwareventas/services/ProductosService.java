package com.iesrfa.especializacion.softwareventas.services;
import com.iesrfa.especializacion.softwareventas.controllers.dto.ProductosDto;
import com.iesrfa.especializacion.softwareventas.models.ProductosEntity;
import com.iesrfa.especializacion.softwareventas.services.repository.ProductosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class ProductosService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ProductosRepository repository;
    public List<ProductosDto> getAll() {
        try {
            return repository.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, ProductosDto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }
    public ProductosDto saveProducto(ProductosDto registrar){
        try{
            return this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registrar, ProductosEntity.class)
                    ),ProductosDto.class);

        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteProducto(UUID idproducto){
        try{
            Optional<ProductosEntity> registrar=
                    repository.findById(idproducto);
            if(registrar.isPresent()){
                repository.delete(registrar.get());
                return true;
            }
            return false;
        }catch(Exception ex){
            return null;

        }
    }

    //

}
