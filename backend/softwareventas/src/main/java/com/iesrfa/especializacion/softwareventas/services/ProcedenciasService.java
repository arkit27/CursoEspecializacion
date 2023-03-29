package com.iesrfa.especializacion.softwareventas.services;
import com.iesrfa.especializacion.softwareventas.controllers.dto.CategoriasDto;
import com.iesrfa.especializacion.softwareventas.controllers.dto.ProcedenciasDto;
import com.iesrfa.especializacion.softwareventas.models.ProcedenciasEntity;
import com.iesrfa.especializacion.softwareventas.services.repository.ProcedenciasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class ProcedenciasService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ProcedenciasRepository repository;
    public List<ProcedenciasDto> getAll() {
        try {
            return repository.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, ProcedenciasDto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }
    public ProcedenciasDto saveProcedencias(ProcedenciasDto registrar){
        try{
            return this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registrar, ProcedenciasEntity.class)
                    ),ProcedenciasDto.class);

        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteProcedencias(UUID idprocedencia){
        try{
            Optional<ProcedenciasEntity> registrar=
                    repository.findById(idprocedencia);
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
