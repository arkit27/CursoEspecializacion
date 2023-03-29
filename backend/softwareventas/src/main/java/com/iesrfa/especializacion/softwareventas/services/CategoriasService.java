package com.iesrfa.especializacion.softwareventas.services;
import com.iesrfa.especializacion.softwareventas.controllers.dto.CategoriasDto;
import com.iesrfa.especializacion.softwareventas.models.CategoriasEntity;
import com.iesrfa.especializacion.softwareventas.services.repository.CategoriasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class CategoriasService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CategoriasRepository repository;
    public List<CategoriasDto> getAll() {
        try {
            return repository.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, CategoriasDto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }
    public CategoriasDto saveCategoria(CategoriasDto registrar){
        try{
            return this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registrar, CategoriasEntity.class)
                    ),CategoriasDto.class);

        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteCategoria(UUID idcategoria){
        try{
            Optional<CategoriasEntity> registrar=
                    repository.findById(idcategoria);
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
