package com.iesrfa.especializacion.softwareventas.controllers;
import com.iesrfa.especializacion.softwareventas.controllers.dto.DetalleVentaDto;
import com.iesrfa.especializacion.softwareventas.services.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/v1/detalleventa")
@CrossOrigin(origins = "*")
public class DetalleVentaController {
    @Autowired
    DetalleVentaService servicio;
    @GetMapping()
    public ResponseEntity<List<DetalleVentaDto>> getAll(){
        try{
            List<DetalleVentaDto> datos=servicio.getAll();
            return new ResponseEntity<>(datos, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping()
    public ResponseEntity<DetalleVentaDto> save(@RequestBody DetalleVentaDto dto){
        try{

            return new ResponseEntity<>(servicio.saveDetalleVenta(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping()
    public ResponseEntity<DetalleVentaDto> update(@RequestBody DetalleVentaDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveDetalleVenta(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        try{
            String aa=Boolean.TRUE.equals(servicio.deleteDetalleVenta(id))?"REGISTRO ELIMINADO":"Error al eliminar";
            return  new ResponseEntity<>(aa,HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
