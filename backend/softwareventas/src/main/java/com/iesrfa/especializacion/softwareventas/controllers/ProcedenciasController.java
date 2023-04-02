package com.iesrfa.especializacion.softwareventas.controllers;
import com.iesrfa.especializacion.softwareventas.controllers.dto.ProcedenciasDto;
import com.iesrfa.especializacion.softwareventas.services.ProcedenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
@RestController()
@RequestMapping("/v1/procedencias")
@CrossOrigin(origins = "*")
public class ProcedenciasController {
    @Autowired
    ProcedenciasService servicio;
    @GetMapping()
    public ResponseEntity<List<ProcedenciasDto>> getAll(){
        try{
            List<ProcedenciasDto> datos=servicio.getAll();
            return new ResponseEntity<>(datos, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping()
    public ResponseEntity<ProcedenciasDto> save(@RequestBody ProcedenciasDto dto){
        try{

            return new ResponseEntity<>(servicio.saveProcedencias(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping()
    public ResponseEntity<ProcedenciasDto> update(@RequestBody ProcedenciasDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveProcedencias(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        try{
            String aa=Boolean.TRUE.equals(servicio.deleteProcedencias(id))?"REGISTRO ELIMINADO":"Error al eliminar";
            return  new ResponseEntity<>(aa,HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
