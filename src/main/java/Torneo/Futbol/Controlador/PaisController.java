package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.Arbitro;
import Torneo.Futbol.Modelo.Estadio;
import Torneo.Futbol.Modelo.Jugador;
import Torneo.Futbol.Modelo.Pais;
import Torneo.Futbol.Repositorio.ArbitroRepositorio;
import Torneo.Futbol.Repositorio.EstadioRepositorio;
import Torneo.Futbol.Repositorio.JugadorRepositorio;
import Torneo.Futbol.Repositorio.PaisRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/Torneo/Paises")
public class PaisController {
    @Autowired
    PaisRepositorio paisRepositorio;
    @PostMapping(path = "/AgregarPais")
    public ResponseEntity<Pais> guardarPais(@Valid @RequestBody Pais pais){
            Pais paisGuardado = paisRepositorio.save(pais);
            URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(paisGuardado.getId()).toUri();
            return ResponseEntity.created(ubicacion).body(paisGuardado);
    }
    @Autowired
    ArbitroRepositorio arbitroRepositorio;
    @Autowired
    EstadioRepositorio estadioRepositorio;
    @Autowired
    JugadorRepositorio jugadorRepositorio;
    @GetMapping(path = "/MostrarPaises")
    public List<Pais> listarPaises(){
        List<Pais> pais = (List<Pais>) paisRepositorio.findAll();
            for (Pais p:pais){
                List<Arbitro> arbitros =  arbitroRepositorio.findAll();
                for (Arbitro a:arbitros){
                    if (arbitros.size() >= 0) {
                        String paisarbitro = a.getPais().getNombre();
                        a.setPaisArbitro(paisarbitro);
                    }
                }
                List<Estadio> estadios =  estadioRepositorio.findAll();
                for (Estadio e:estadios){
                    if (estadios.size() >= 0) {
                        String paisestadio = e.getPais().getNombre();
                        e.setPaisEstadio(paisestadio);
                    }
                }
                List<Jugador> jugadores = (List<Jugador>) jugadorRepositorio.findAll();
                for (Jugador j : jugadores){
                    String paisJugador = j.getPais().getNombre();
                    j.setPaisJugador(paisJugador);
                }
            }
        return pais;
    }
}
