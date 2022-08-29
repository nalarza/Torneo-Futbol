package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.Evento;
import Torneo.Futbol.Servicio.EventoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/Torneo/Evento")
public class EventoController {
    @Autowired
    private EventoServicio servicio;

    @GetMapping(path = "/MostrarEventos")
     public List<Evento> listarEvento(){
         return servicio.listarEvento();
    }
    @PostMapping(path = "/AgregarEvento")
    public ResponseEntity<Evento> guardarEvento(@Valid @RequestBody Evento evento){
        return servicio.guardarEvento(evento);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Evento> eliminarEvento(@PathVariable Integer id){
        return servicio.eliminarEvento(id);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Evento> actualizarEvento (@Valid @RequestBody Evento evento,@PathVariable Integer id){
        return servicio.actualizarEvento(evento,id);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Evento> traerId (@Valid @PathVariable Integer id){
        return servicio.traerId(id);
    }
}