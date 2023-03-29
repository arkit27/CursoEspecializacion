package com.iesrfa.especializacion.softwareventas.controllers;
import com.iesrfa.especializacion.softwareventas.controllers.dto.MarcasDto;
import com.iesrfa.especializacion.softwareventas.services.MarcasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/v1/marcas")
@CrossOrigin(origins = "*")
public class MarcasController {
    @Autowired
    MarcasService servicio;
    @GetMapping()
    public ResponseEntity<List<MarcasDto>> getAll(){
        try{
            List<MarcasDto> datos=servicio.getAll();
            return new ResponseEntity<>(datos, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping()
    public ResponseEntity<MarcasDto> save(@RequestBody MarcasDto dto){
        try{

            return new ResponseEntity<>(servicio.saveMarca(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping()
    public ResponseEntity<MarcasDto> update(@RequestBody MarcasDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveMarca(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        try{
            String aa=Boolean.TRUE.equals(servicio.deleteMarca(id))?"REGISTRO ELIMINADO":"Error al eliminar";
            return  new ResponseEntity<>(aa,HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
