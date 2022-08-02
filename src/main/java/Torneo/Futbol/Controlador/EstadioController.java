package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.Arbitro;
import Torneo.Futbol.Modelo.Estadio;
import Torneo.Futbol.Repositorio.ArbitroRepositorio;
import Torneo.Futbol.Repositorio.EstadioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Torneo/Estadio")
public class EstadioController {

    @Autowired
    EstadioRepositorio estadioRepositorio;

    @GetMapping(path = "/MostrarEstadios")
    public List<Estadio> listarEstadio(){
        List<Estadio> estadios =  estadioRepositorio.findAll();
        for (Estadio e:estadios){
            if (estadios.size() >= 0) {
               String pais = e.getPais().getNombre();
               e.setPaisEstadio(pais);
            }
        }
        return estadios;
    }

    @PostMapping(path = "/AgregarEstadio")
    public ResponseEntity<Estadio> guardarEstadio(@Valid @RequestBody Estadio estadio){
        try{
        Estadio estadioGuardado = estadioRepositorio.save(estadio);
            URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(estadioGuardado.getId()).toUri();
            return ResponseEntity.created(ubicacion).body(estadioGuardado);
        }catch (Exception e){
            return new ResponseEntity("El pais no existe",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Estadio> eliminarEstadio(@PathVariable Integer id){
        Optional<Estadio> estadioOptional = estadioRepositorio.findById(id);
        estadioRepositorio.delete(estadioOptional.get());
        return new ResponseEntity("Estadio Eliminado",HttpStatus.OK);    }
}

/*
    }*/