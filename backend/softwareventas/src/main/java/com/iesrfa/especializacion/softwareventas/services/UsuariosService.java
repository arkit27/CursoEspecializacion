package com.iesrfa.especializacion.softwareventas.services;
import com.iesrfa.especializacion.softwareventas.controllers.dto.UsuarioLoginResponse;
import com.iesrfa.especializacion.softwareventas.controllers.dto.UsuariosDto;
import com.iesrfa.especializacion.softwareventas.models.UsuariosEntity;
import com.iesrfa.especializacion.softwareventas.services.repository.UsuariosRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
@Slf4j
public class UsuariosService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UsuariosRepository repository;
    public List<UsuariosDto> getAll() {
        try {
            return repository.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, UsuariosDto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }
    public UsuariosDto saveUsuario(UsuariosDto registrar){
        try{
            return this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registrar,UsuariosEntity.class)
                    ),UsuariosDto.class);

        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteUsuario(UUID idusuario){
        try{
            Optional<UsuariosEntity> registrar=
                    repository.findById(idusuario);
            if(registrar.isPresent()){
                repository.delete(registrar.get());
                return true;
            }
            return false;
        }catch(Exception ex){
            return null;

        }
    }

    public UsuarioLoginResponse login(String user, String clave){
        UsuarioLoginResponse response= new UsuarioLoginResponse();
        response.setCodigo(400);
        try{
            UsuariosEntity usuariouser=repository.findByUser(user);
            if(usuariouser==null){
                response.setMensaje("Usuario no Existe");
                response.setToken("");
                return response;
            }
            System.out.println(usuariouser);
            if(!usuariouser.getPassword().equals(clave)){
                response.setMensaje("Usuario y clave incorrecto");
                return response;
            }
            String datos="id="+usuariouser.getId()+"!=!";
            datos+="usuario="+usuariouser.getUser()+"!=!";
            datos+="password="+usuariouser.getPassword()+"!=!";
            datos+="nombre="+usuariouser.getNombre()+"!=!";
            datos+="rol="+usuariouser.getRol()+"!=!";
            datos+="fechayhora="+ LocalDateTime.now();
            Base64 base64 = new Base64();
            String token= new String(base64.encode(datos.getBytes()));
            response.setCodigo(200);
            response.setMensaje("Inicio de Sesión Satisfactorio");
            response.setToken(token);
            return response;
        }catch(Exception ex){
            log.error("error al loguearse log",ex.getMessage());
            response.setMensaje("error al loguearse  -> "+ ex.getCause());
            response.setToken("");
            return response;
        }
    }

    public String findByUserAndPassword(String user, String clave){
        try{
            UsuariosEntity usuariosEntity=repository.findByUserAndPassword(user,clave);
            if(usuariosEntity.equals(null)) return "";
            String datos="id="+usuariosEntity.getId()+"!=!";
            datos+="usuario="+usuariosEntity.getUser()+"!=!";
            datos+="password="+usuariosEntity.getPassword()+"!=!";
            datos+="nombre="+usuariosEntity.getNombre()+"!=!";
            datos+="fechayhora="+ LocalDateTime.now();
            Base64 base64 = new Base64();
            return new String(base64.encode(datos.getBytes()));
        }catch(Exception ex){
            log.error("error al loguearse",ex.getCause());
            return null;
        }
    }
}
