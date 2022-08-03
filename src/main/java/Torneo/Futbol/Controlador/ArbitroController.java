package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.Arbitro;
import Torneo.Futbol.Repositorio.ArbitroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/Torneo/Arbitro")
public class ArbitroController {

    @Autowired
    ArbitroRepositorio arbitroRepositorio;

    @GetMapping(path = "/MostrarArbitros")
    public List<Arbitro> listarArbitros(){
        List<Arbitro> arbitros =  arbitroRepositorio.findAll();
        for (Arbitro a:arbitros){
            if (arbitros.size() >= 0) {
               String pais = a.getPais().getNombre();
               a.setPaisArbitro(pais);
            }
        }
        return arbitros;
    }

    @PostMapping(path = "/AgregarArbitro")
    public ResponseEntity<Arbitro> guardarArbitro(@Valid @RequestBody Arbitro arbitro){
        try{
        Arbitro arbitroGuardado = arbitroRepositorio.save(arbitro);
            URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(arbitroGuardado.getId()).toUri();
            return ResponseEntity.created(ubicacion).body(arbitroGuardado);
        }catch (Exception e){
            return new ResponseEntity("El pais no existe",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Arbitro> eliminarArbitro(@PathVariable Integer id){
      try{
          arbitroRepositorio.deleteById(id);
          return new ResponseEntity("Arbitro Eliminado",HttpStatus.OK);
      }catch (Exception e){
          return new ResponseEntity("Arbitro No Encontrado, Por Favor Intentelo De Nuevo",HttpStatus.BAD_REQUEST);
      }

    }
}

/*
    */