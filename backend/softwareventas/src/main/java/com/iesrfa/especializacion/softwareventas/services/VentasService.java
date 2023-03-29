package com.iesrfa.especializacion.softwareventas.services;
import com.iesrfa.especializacion.softwareventas.controllers.dto.VentasDto;
import com.iesrfa.especializacion.softwareventas.models.VentasEntity;
import com.iesrfa.especializacion.softwareventas.services.repository.VentasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class VentasService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    VentasRepository repository;
    public List<VentasDto> getAll() {
        try {
            return repository.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, VentasDto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }
    public VentasDto saveVenta(VentasDto registrar){
        try{
            return this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registrar, VentasEntity.class)
                    ),VentasDto.class);

        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteVenta(UUID idventa){
        try{
            Optional<VentasEntity> registrar=
                    repository.findById(idventa);
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
