package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.Jugador;
import Torneo.Futbol.Repositorio.JugadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(path = "/Torneo/Jugadores")
public class JugadorController {
    @Autowired
    JugadorRepositorio jugadorRepositorio;
    @PostMapping(path = "/AgregarJugador")
    public ResponseEntity<Jugador> guardarJugador(@Valid @RequestBody Jugador jugador){
        try{
            Jugador jugadorGuardado = jugadorRepositorio.save(jugador);
            URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(jugadorGuardado.getId()).toUri();
            return ResponseEntity.created(ubicacion).body(jugadorGuardado);
        }catch (Exception e){
            return new ResponseEntity("El Equipo No Existe : "+e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/MostrarJugadores")
    public ResponseEntity<Iterable<Jugador>> listarJugadores(){
        return ResponseEntity.ok(jugadorRepositorio.findAll());
    }
}
/*   */