package com.iesrfa.especializacion.softwareventas.services;
import com.iesrfa.especializacion.softwareventas.controllers.dto.ProveedoresDto;
import com.iesrfa.especializacion.softwareventas.models.ProveedoresEntity;
import com.iesrfa.especializacion.softwareventas.services.repository.ProveedoresRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class ProveedoresService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ProveedoresRepository repository;
    public List<ProveedoresDto> getAll() {
        try {
            return repository.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, ProveedoresDto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }
    public ProveedoresDto saveProveedor(ProveedoresDto registrar){
        try{
            return this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registrar, ProveedoresEntity.class)
                    ),ProveedoresDto.class);

        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteProveedor(UUID idproveedor){
        try{
            Optional<ProveedoresEntity> registrar=
                    repository.findById(idproveedor);
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
