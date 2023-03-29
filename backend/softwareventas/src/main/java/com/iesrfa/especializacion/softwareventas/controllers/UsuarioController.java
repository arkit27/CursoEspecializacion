package com.iesrfa.especializacion.softwareventas.controllers;
import com.iesrfa.especializacion.softwareventas.controllers.dto.UsuarioLoginDto;
import com.iesrfa.especializacion.softwareventas.controllers.dto.UsuarioLoginResponse;
import com.iesrfa.especializacion.softwareventas.controllers.dto.UsuariosDto;
import com.iesrfa.especializacion.softwareventas.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
@RestController()
@RequestMapping("/v1/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    @Autowired
    UsuariosService servicio;
    @GetMapping()
    public ResponseEntity<List<UsuariosDto>> getAll(){
        try{
            List<UsuariosDto> datos=servicio.getAll();
            return new ResponseEntity<>(datos,HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping()
    public ResponseEntity<UsuariosDto> save(@RequestBody UsuariosDto dto){
        try{

            return new ResponseEntity<>(servicio.saveUsuario(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping()
    public ResponseEntity<UsuariosDto> update(@RequestBody UsuariosDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveUsuario(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        try{
            String aa=Boolean.TRUE.equals(servicio.deleteUsuario(id))?"REGISTRO ELIMINADO":"Error al eliminar";
            return  new ResponseEntity<>(aa,HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<UsuarioLoginResponse> login(@RequestBody UsuarioLoginDto dto){
        return new ResponseEntity<UsuarioLoginResponse>(servicio.login(
                dto.getUser(), dto.getClave()),HttpStatus.OK);
    }
    @PostMapping("/login2")
    public ResponseEntity<String> login2
            (@RequestBody UsuarioLoginDto dto){
        return new ResponseEntity<>(servicio.findByUserAndPassword(
                dto.getUser(), dto.getClave()),HttpStatus.OK);
    }
}
