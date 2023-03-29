package com.iesrfa.especializacion.softwareventas.controllers;
import com.iesrfa.especializacion.softwareventas.controllers.dto.MenuDto;
import com.iesrfa.especializacion.softwareventas.services.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
@RestController()
@RequestMapping("/v1/menu")
@CrossOrigin(origins = "*")
public class MenuController {
    @Autowired
    MenusService servicio;

    @GetMapping()
    public ResponseEntity<List<MenuDto>> getAll(){
        try{
            return  new ResponseEntity<>(servicio.getAll(), HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("menupadres")
    public ResponseEntity<List<MenuDto>> getAllConMenuPadres(){
        try{
            return  new ResponseEntity<>(servicio.getAllConMenuPadres(), HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("buscar/{nombre}")
    public ResponseEntity<List<MenuDto>> finAllMenuPadressearch0(@PathVariable(name="nombre",required = false) String nom){
        try{
            return  new ResponseEntity<>(servicio.finAllMenuPadressearch0(nom), HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping()
    public ResponseEntity<MenuDto> save(@RequestBody MenuDto dto){
        try{
            return  new ResponseEntity<>(servicio.save(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping()
    public ResponseEntity<MenuDto> update(@RequestBody MenuDto dto){
        try{
            return  new ResponseEntity<>(servicio.save(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        try{
            String mensaje=Boolean.TRUE.equals(servicio.delete(id))?"Registro Eliminado":"Error Al Eliminar Registro";
            return  new ResponseEntity<>(mensaje,HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}