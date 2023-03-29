package com.iesrfa.especializacion.softwareventas.services;
import com.iesrfa.especializacion.softwareventas.controllers.dto.CategoriasDto;
import com.iesrfa.especializacion.softwareventas.controllers.dto.ClientesDto;
import com.iesrfa.especializacion.softwareventas.controllers.dto.UsuariosDto;
import com.iesrfa.especializacion.softwareventas.models.CategoriasEntity;
import com.iesrfa.especializacion.softwareventas.models.ClientesEntity;
import com.iesrfa.especializacion.softwareventas.models.UsuariosEntity;
import com.iesrfa.especializacion.softwareventas.services.repository.CategoriasRepository;
import com.iesrfa.especializacion.softwareventas.services.repository.ClientesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientesService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ClientesRepository repository;
    public List<ClientesDto> getAll() {
        try {
            return repository.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, ClientesDto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }
    public ClientesDto saveCliente(ClientesDto registrar){
        try{
            return this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registrar, ClientesEntity.class)
                    ),ClientesDto.class);

        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteCliente(UUID idcliente){
        try{
            Optional<ClientesEntity> registrar=
                    repository.findById(idcliente);
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
