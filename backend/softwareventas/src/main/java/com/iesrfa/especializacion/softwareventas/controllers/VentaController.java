package com.iesrfa.especializacion.softwareventas.controllers;
import com.iesrfa.especializacion.softwareventas.controllers.dto.VentasDto;
import com.iesrfa.especializacion.softwareventas.services.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
@RestController()
@RequestMapping("/v1/ventas")
@CrossOrigin(origins = "*")
public class VentaController {
    @Autowired
    VentasService servicio;
    @GetMapping()
    public ResponseEntity<List<VentasDto>> getAll(){
        try{
            List<VentasDto> datos=servicio.getAll();
            return new ResponseEntity<>(datos, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping()
    public ResponseEntity<VentasDto> save(@RequestBody VentasDto dto){
        try{

            return new ResponseEntity<>(servicio.saveVenta(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping()
    public ResponseEntity<VentasDto> update(@RequestBody VentasDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveVenta(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        try{
            String aa=Boolean.TRUE.equals(servicio.deleteVenta(id))?"REGISTRO ELIMINADO":"Error al eliminar";
            return  new ResponseEntity<>(aa,HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
