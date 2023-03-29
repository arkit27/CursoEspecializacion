package com.iesrfa.especializacion.softwareventas.controllers;
import com.iesrfa.especializacion.softwareventas.controllers.dto.FacturacionDto;
import com.iesrfa.especializacion.softwareventas.services.FacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
@RestController()
@RequestMapping("/v1/facturacion")
@CrossOrigin(origins = "*")
public class FacturacionController {
    @Autowired
    FacturacionService servicio;
    @GetMapping()
    public ResponseEntity<List<FacturacionDto>> getAll(){
        try{
            List<FacturacionDto> datos=servicio.getAll();
            return new ResponseEntity<>(datos, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping()
    public ResponseEntity<FacturacionDto> save(@RequestBody FacturacionDto dto){
        try{

            return new ResponseEntity<>(servicio.saveFacturacion(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping()
    public ResponseEntity<FacturacionDto> update(@RequestBody FacturacionDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveFacturacion(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        try{
            String aa=Boolean.TRUE.equals(servicio.deleteFacturacion(id))?"REGISTRO ELIMINADO":"Error al eliminar";
            return  new ResponseEntity<>(aa,HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
