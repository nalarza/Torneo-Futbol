package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.Estadistica;
import Torneo.Futbol.Modelo.Evento;
import Torneo.Futbol.Repositorio.EstadisticaRepositorio;
import Torneo.Futbol.Repositorio.EventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Torneo/Estadistica")
public class EstadisticaController {

    @Autowired
    EstadisticaRepositorio estadisticaRepositorio;

    @GetMapping(path = "/MostrarEstadisticas")
    public List<Estadistica> listarEstadisticas(){
         List<Estadistica> estadisticas =  estadisticaRepositorio.findAll();
        return  estadisticas;
    }

    @PostMapping(path = "/AgregarEstadistica")
    public ResponseEntity<Estadistica> guardarEstadistica(@Valid @RequestBody Estadistica estadistica){
            estadisticaRepositorio.save(estadistica);
        return new ResponseEntity("Estadistica Guardada",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Estadistica> eliminarEstadistica(@PathVariable Integer id){
      try{
          estadisticaRepositorio.deleteById(id);
          return new ResponseEntity("Estadistica Eliminada",HttpStatus.OK);
      }catch (Exception e){
          return new ResponseEntity("Estadistica No Encontrada, Por Favor Intentelo De Nuevo",HttpStatus.BAD_REQUEST);
      }

    }
    @Autowired
    EventoRepositorio eventoRepositorio;
    @PutMapping(path = "/{id}")
    public ResponseEntity<Estadistica> actualizarEstadistica (@Valid @RequestBody Estadistica estadistica,@PathVariable Integer id){
            Optional<Evento> eventoOptional = eventoRepositorio.findById(estadistica.getEvento().getId());
            Optional<Estadistica> estadisticaOptional = estadisticaRepositorio.findById(id);

            if (estadisticaOptional.isPresent()){
                if (eventoOptional.isPresent()){
                    estadistica.setEvento(eventoOptional.get());
                    estadistica.setId(estadisticaOptional.get().getId());
                    estadisticaRepositorio.save(estadistica);
                }else{
                    return new ResponseEntity("Evento No Encontrado", HttpStatus.BAD_REQUEST);
                }
            }else {
                return new ResponseEntity("Estadistica No Encontrada",HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity("Estadistica Actualizada",HttpStatus.OK);

    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Estadistica> traerId(@Valid @PathVariable Integer id){
        Optional<Estadistica> estadisticaOptional = estadisticaRepositorio.findById(id);
        if (estadisticaOptional.isPresent()){
            return new ResponseEntity(estadisticaOptional,HttpStatus.OK);
        }else   {
            return  new ResponseEntity("EStadistica No Encontrada",HttpStatus.BAD_REQUEST);
        }
    }
}

/*
    */