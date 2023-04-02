package com.iesrfa.especializacion.softwareventas.controllers;
import com.iesrfa.especializacion.softwareventas.controllers.dto.ProveedoresDto;
import com.iesrfa.especializacion.softwareventas.services.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/v1/proveedores")
@CrossOrigin(origins = "*")
public class ProveedoresController {
    @Autowired
    ProveedoresService servicio;
    @GetMapping()
    public ResponseEntity<List<ProveedoresDto>> getAll(){
        try{
            List<ProveedoresDto> datos=servicio.getAll();
            return new ResponseEntity<>(datos, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping()
    public ResponseEntity<ProveedoresDto> save(@RequestBody ProveedoresDto dto){
        try{

            return new ResponseEntity<>(servicio.saveProveedor(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping()
    public ResponseEntity<ProveedoresDto> update(@RequestBody ProveedoresDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveProveedor(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        try{
            String aa=Boolean.TRUE.equals(servicio.deleteProveedor(id))?"REGISTRO ELIMINADO":"Error al eliminar";
            return  new ResponseEntity<>(aa,HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
