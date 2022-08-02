package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.Equipo;
import Torneo.Futbol.Modelo.Jugador;
import Torneo.Futbol.Repositorio.EquipoRepositorio;
import Torneo.Futbol.Repositorio.JugadorRepositorio;
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
@RequestMapping(path = "/Torneo/Equipos")
public class EquipoController {

    @Autowired
    EquipoRepositorio equipoRepositorio;

    @Autowired
    JugadorRepositorio jugadorRepositorio;

    @GetMapping(path = "/MostrarEquipos")
    public List<Equipo> listarEquipos(){
        List<Equipo> equipos = (List<Equipo>) equipoRepositorio.findAll();
        for (Equipo e:equipos){
            if (equipos.size() >= 0){
            String paisEquipo = e.getPais().getNombre();
            e.setPaisDelEquipo(paisEquipo);
            }
            List<Jugador> jugadores = (List<Jugador>) jugadorRepositorio.findAll();
            for (Jugador j : jugadores){
                String pais = j.getPais().getNombre();
                j.setPaisJugador(pais);
            }
        }
       //return ResponseEntity.ok(equipoRepositorio.findAll());
        return equipos;
    }

    @PostMapping(path = "/AgregarEquipo")
    public ResponseEntity<Equipo> guardarEquipo(@Valid @RequestBody Equipo equipo){
        try{
        Equipo equipoGuardado = equipoRepositorio.save(equipo);
            URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(equipoGuardado.getId()).toUri();
            return ResponseEntity.created(ubicacion).body(equipoGuardado);
        }catch (Exception e){
            return new ResponseEntity("El pais no existe",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Equipo> eliminarEquipo(@PathVariable Integer id){
        Optional<Equipo> equipoOptional = equipoRepositorio.findById(id);
        equipoRepositorio.delete(equipoOptional.get());
        return new ResponseEntity("Equipo Eliminado",HttpStatus.OK);    }
}

/*
    }*/