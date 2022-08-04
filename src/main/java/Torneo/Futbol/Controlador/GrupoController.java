package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.Equipo;
import Torneo.Futbol.Modelo.Grupo;
import Torneo.Futbol.Modelo.Jugador;
import Torneo.Futbol.Repositorio.EquipoRepositorio;
import Torneo.Futbol.Repositorio.GrupoRepositorio;
import Torneo.Futbol.Repositorio.JugadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/Torneo/Grupos")
public class GrupoController {

    @Autowired
    GrupoRepositorio grupoRepositorio;
    @Autowired
    EquipoRepositorio equipoRepositorio;
    @Autowired
    JugadorRepositorio jugadorRepositorio;

    @GetMapping(path = "/MostrarGrupos")
    public List<Grupo> listarGrupo(){
        List<Grupo> grupos =  grupoRepositorio.findAll();
        for (Grupo g:grupos){
            List<Equipo> equipos = (List<Equipo>) equipoRepositorio.findAll();
            for (Equipo e:equipos){
                if (equipos.size() >= 0){
                    String paisEquipo = e.getPais().getNombre();
                    e.setPaisDelEquipo(paisEquipo);
                }
            }
            List<Jugador> jugadores = (List<Jugador>) jugadorRepositorio.findAll();
            for (Jugador j : jugadores){
                String pais = j.getPais().getNombre();
                j.setPaisJugador(pais);
            }
        }
        return grupos;
    }

    @PostMapping(path = "/AgregarGrupo")
    public ResponseEntity<Grupo> guardarArbitro(@Valid @RequestBody Grupo grupo){
            grupoRepositorio.save(grupo);
        return new ResponseEntity("Grupo Guardado",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Grupo> eliminarArbitro(@PathVariable Integer id){
      try{
          grupoRepositorio.deleteById(id);
          return new ResponseEntity("Grupo Eliminado",HttpStatus.OK);
      }catch (Exception e){
          return new ResponseEntity("Grupo No Encontrado, Por Favor Intentelo De Nuevo",HttpStatus.BAD_REQUEST);
      }

    }
}

/*
    */