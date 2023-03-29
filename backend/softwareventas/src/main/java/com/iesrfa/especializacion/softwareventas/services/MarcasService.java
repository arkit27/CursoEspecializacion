package com.iesrfa.especializacion.softwareventas.services;
import com.iesrfa.especializacion.softwareventas.controllers.dto.MarcasDto;
import com.iesrfa.especializacion.softwareventas.models.MarcasEntity;
import com.iesrfa.especializacion.softwareventas.services.repository.MarcasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class MarcasService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    MarcasRepository repository;
    public List<MarcasDto> getAll() {
        try {
            return repository.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, MarcasDto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }
    public MarcasDto saveMarca(MarcasDto registrar){
        try{
            return this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registrar, MarcasEntity.class)
                    ),MarcasDto.class);

        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteMarca(UUID idmarca){
        try{
            Optional<MarcasEntity> registrar=
                    repository.findById(idmarca);
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
