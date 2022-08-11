package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.Evento;
import Torneo.Futbol.Modelo.Partido;
import Torneo.Futbol.Repositorio.EventoRepositorio;
import Torneo.Futbol.Repositorio.PartidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Torneo/Evento")
public class EventoController {
    @Autowired
    PartidoRepositorio partidoRepositorio;
    @Autowired
    EventoRepositorio eventoRepositorio;

    @GetMapping(path = "/MostrarEventos")
    public List<Evento> listarEvento(){
         List<Evento> eventos =  eventoRepositorio.findAll();
        return  eventos;
    }

    @PostMapping(path = "/AgregarEvento")
    public ResponseEntity<Evento> guardarEvento(@Valid @RequestBody Evento evento){
            eventoRepositorio.save(evento);
        return new ResponseEntity("Evento Guardado",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Evento> eliminarEvento(@PathVariable Integer id){
      try{
          eventoRepositorio.deleteById(id);
          return new ResponseEntity("Evento Eliminado",HttpStatus.OK);
      }catch (Exception e){
          return new ResponseEntity("Evento No Encontrado, Por Favor Intentelo De Nuevo",HttpStatus.BAD_REQUEST);
      }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Evento> actualizarEvento (@Valid @RequestBody Evento evento,@PathVariable Integer id){
        Optional<Evento> eventoOptional = eventoRepositorio.findById(id);
        Optional<Partido> partidoOptional = partidoRepositorio.findById(evento.getPartido().getId());
        if (eventoOptional.isPresent()){
            if (partidoOptional.isPresent()){
                evento.setPartido(partidoOptional.get());
                evento.setId(eventoOptional.get().getId());
                eventoRepositorio.save(evento);
                return new ResponseEntity("Evento Actualizado",HttpStatus.OK);
            }else{
                return new ResponseEntity("Partido No Encontrado",HttpStatus.BAD_REQUEST);
            }
        }else{
            return new ResponseEntity("Evento No Encontrado",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Evento> traerId (@Valid @PathVariable Integer id){
        Optional<Evento> eventoOptional = eventoRepositorio.findById(id);
        if (eventoOptional.isPresent()){
            return new ResponseEntity(eventoOptional,HttpStatus.OK);
        }else{
            return new ResponseEntity("Evento No Encontrado",HttpStatus.BAD_REQUEST);
        }
    }
}

/*
    */