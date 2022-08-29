package Torneo.Futbol.Servicio;

import Torneo.Futbol.Modelo.Equipo;
import Torneo.Futbol.Modelo.Jugador;
import Torneo.Futbol.Modelo.Pais;
import Torneo.Futbol.Repositorio.EquipoRepositorio;
import Torneo.Futbol.Repositorio.JugadorRepositorio;
import Torneo.Futbol.Repositorio.PaisRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JugadorServicio {
    @Autowired
    PaisRepositorio paisRepositorio;
    @Autowired
    EquipoRepositorio equipoRepositorio;
    @Autowired
    JugadorRepositorio jugadorRepositorio;

    public ResponseEntity<Jugador> guardarJugador(@Valid @RequestBody Jugador jugador){
        try{
            jugadorRepositorio.save(jugador);
            return new ResponseEntity("Jugador Guardado", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("El Equipo No Existe : "+e, HttpStatus.BAD_REQUEST);
        }
    }

    public List<Jugador> listarJugadores(){
        List<Jugador> jugadores = (List<Jugador>) jugadorRepositorio.findAll();
        return jugadores;
    }

    public ResponseEntity<Jugador> eliminarJugadores(@PathVariable Integer id){
        try {
            jugadorRepositorio.deleteById(id);
            return new ResponseEntity("Jugador Eliminado",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Jugador No Encontrado, Por Favor Intentelo De Nuevo",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Jugador> actualizarJugador (@Valid @RequestBody Jugador jugador, @PathVariable Integer id){
        Optional<Equipo> equipoOptional = equipoRepositorio.findById(jugador.getEquipo().getId());
        Optional<Jugador> jugadorOptional = jugadorRepositorio.findById(id);
        Optional<Pais> paisOptional = paisRepositorio.findById(jugador.getPais().getId());
        if (jugadorOptional.isPresent()){
            if (equipoOptional.isPresent()){
                if (paisOptional.isPresent()){
                    jugador.setPais(paisOptional.get());
                    jugador.setEquipo(equipoOptional.get());
                    jugador.setId(jugadorOptional.get().getId());
                    jugadorRepositorio.save(jugador);
                    return new ResponseEntity("Jugador Actualizado",HttpStatus.OK);
                }else{
                    return new ResponseEntity("Pais No Encontrado",HttpStatus.BAD_REQUEST);
                }
            }else {
                return new ResponseEntity("Equipo No Encontrado",HttpStatus.BAD_REQUEST);
            }
        }else{
            return new ResponseEntity("Jugador No Encontrado",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Jugador> filtrar(@RequestParam (required = false, name = "nombre") String nombre, @RequestParam (required = false, name = "apellido") String apellido) {
        List<Jugador> jugadorList = listarJugadores().stream().filter(x -> x.getNombre().equalsIgnoreCase(nombre) || x.getApellido().equalsIgnoreCase(apellido)).collect(Collectors.toList());
        if (jugadorList.isEmpty()){
            return new ResponseEntity("Jugador No Encontrado",HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity(jugadorList,HttpStatus.OK);
        }
    }

    public ResponseEntity<Jugador> traerPorId (@Valid @PathVariable Integer id){
        Optional<Jugador> jugadorOptional = jugadorRepositorio.findById(id);
        if (jugadorOptional.isPresent()){
            return new ResponseEntity(jugadorOptional,HttpStatus.OK);
        }else{
            return new ResponseEntity("Jugador No Encontrado",HttpStatus.BAD_REQUEST);
        }
    }
}
