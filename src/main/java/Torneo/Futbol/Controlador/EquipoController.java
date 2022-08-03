package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.Equipo;
import Torneo.Futbol.Modelo.Jugador;
import Torneo.Futbol.Repositorio.EquipoRepositorio;
import Torneo.Futbol.Repositorio.JugadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        return equipos;
    }

    @PostMapping(path = "/AgregarEquipo")
    public ResponseEntity<Equipo> guardarEquipo(@Valid @RequestBody Equipo equipo){
        try{
            equipoRepositorio.save(equipo);
            return new ResponseEntity("Equipo Guardado",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("El Pais No Existe"+e,HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Equipo> eliminarEquipo(@PathVariable Integer id){
        try{
          equipoRepositorio.deleteById(id);
        return new ResponseEntity("Equipo Eliminado",HttpStatus.OK);  }
    catch (Exception e){
        return new ResponseEntity("Equipo No Encontrado, Por Favor Intentelo De Nuevo",HttpStatus.BAD_REQUEST);

    }
    }
}

/*
    }*/