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
import java.util.List;

@RestController
@RequestMapping(path = "/Torneo/Jugadores")
public class JugadorController {
    @Autowired
    JugadorRepositorio jugadorRepositorio;
    @PostMapping(path = "/AgregarJugador")
    public ResponseEntity<Jugador> guardarJugador(@Valid @RequestBody Jugador jugador){
        try{
          jugadorRepositorio.save(jugador);
            return new ResponseEntity("Jugador Guardado",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("El Equipo No Existe : "+e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/MostrarJugadores")
    public List<Jugador> listarJugadores(){
        List<Jugador> jugadores = (List<Jugador>) jugadorRepositorio.findAll();
        for (Jugador j : jugadores){
            String pais = j.getPais().getNombre();
            j.setPaisJugador(pais);
        }
        return jugadores;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Jugador> eliminarJugadores(@PathVariable Integer id){
        try {
            jugadorRepositorio.deleteById(id);
            return new ResponseEntity("Jugador Eliminado",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Jugador No Encontrado, Por Favor Intentelo De Nuevo",HttpStatus.BAD_REQUEST);
        }
    }

}
/*   */

