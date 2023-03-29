package com.iesrfa.especializacion.softwareventas.services;
import com.iesrfa.especializacion.softwareventas.controllers.dto.FacturacionDto;
import com.iesrfa.especializacion.softwareventas.models.FacturacionEntity;
import com.iesrfa.especializacion.softwareventas.services.repository.FacturacionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class FacturacionService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    FacturacionRepository repository;
    public List<FacturacionDto> getAll() {
        try {
            return repository.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, FacturacionDto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }
    public FacturacionDto saveFacturacion(FacturacionDto registrar){
        try{
            return this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registrar, FacturacionEntity.class)
                    ),FacturacionDto.class);

        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteFacturacion(UUID idfacturacion){
        try{
            Optional<FacturacionEntity> registrar=
                    repository.findById(idfacturacion);
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
