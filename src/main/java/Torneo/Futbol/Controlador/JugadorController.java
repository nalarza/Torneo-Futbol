package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.Jugador;
import Torneo.Futbol.Servicio.JugadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/Torneo/Jugadores")
public class JugadorController {
    @Autowired
    private JugadorServicio servicio;

    @PostMapping(path = "/AgregarJugador")
    public ResponseEntity<Jugador> guardarJugador(@Valid @RequestBody Jugador jugador){
        return servicio.guardarJugador(jugador);
    }
    @GetMapping(path = "/MostrarJugadores")
    public List<Jugador> listarJugadores(){
        return servicio.listarJugadores();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Jugador> eliminarJugadores(@PathVariable Integer id){
        return servicio.eliminarJugadores(id);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Jugador> actualizarJugador (@Valid @RequestBody Jugador jugador, @PathVariable Integer id){
        return servicio.actualizarJugador(jugador, id);
    }
    @GetMapping(path = "/nombreDelJugador")
    public ResponseEntity<Jugador> filtrar(@RequestParam (required = false, name = "nombre") String nombre, @RequestParam (required = false, name = "apellido") String apellido) {
        return servicio.filtrar(nombre, apellido);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Jugador> traerPorId (@Valid @PathVariable Integer id){
        return servicio.traerPorId(id);
    }
}