package com.iesrfa.especializacion.softwareventas.services;
import com.iesrfa.especializacion.softwareventas.controllers.dto.ClientesDto;
import com.iesrfa.especializacion.softwareventas.controllers.dto.DetalleVentaDto;
import com.iesrfa.especializacion.softwareventas.controllers.dto.UsuariosDto;
import com.iesrfa.especializacion.softwareventas.models.ClientesEntity;
import com.iesrfa.especializacion.softwareventas.models.DetalleVentaEntity;
import com.iesrfa.especializacion.softwareventas.models.UsuariosEntity;
import com.iesrfa.especializacion.softwareventas.services.repository.ClientesRepository;
import com.iesrfa.especializacion.softwareventas.services.repository.DetalleVentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DetalleVentaService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    DetalleVentaRepository repository;
    public List<DetalleVentaDto> getAll() {
        try {
            return repository.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, DetalleVentaDto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }
    public DetalleVentaDto saveDetalleVenta(DetalleVentaDto registrar){
        try{
            return this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registrar, DetalleVentaEntity.class)
                    ),DetalleVentaDto.class);

        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteDetalleVenta(UUID iddetalleventa){
        try{
            Optional<DetalleVentaEntity> registrar=
                    repository.findById(iddetalleventa);
            if(registrar.isPresent()){
                repository.delete(registrar.get());
                return true;
            }
            return false;
        }catch(Exception ex){
            return null;

        }
    }
}
