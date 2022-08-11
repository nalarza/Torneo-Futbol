package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.Equipo;
import Torneo.Futbol.Modelo.Grupo;
import Torneo.Futbol.Modelo.Jugador;
import Torneo.Futbol.Modelo.JugadorResponse;
import Torneo.Futbol.Repositorio.EquipoRepositorio;
import Torneo.Futbol.Repositorio.GrupoRepositorio;
import Torneo.Futbol.Repositorio.JugadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        JugadorResponse jugadorResponse = new JugadorResponse();
           List<Equipo> equipos = (List<Equipo>) equipoRepositorio.findAll();
            for (Equipo e:equipos){
                if (equipos.size() >= 0){
                    String paisEquipo = e.getPais().getNombre();
                    e.setPaisDelEquipo(paisEquipo);
                }
            }
            List<Jugador> jugadores = (List<Jugador>) jugadorRepositorio.findAll();
            for (Jugador j : jugadores){
              jugadorResponse.setPaisJuagdor(j.getPais().getNombre());
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
    @PutMapping(path = "/{id}")
    public ResponseEntity<Grupo> actualizarGrupo(@Valid @RequestBody Grupo grupo, @PathVariable Integer id){
        Optional<Grupo> grupoOptional = grupoRepositorio.findById(id);
        if (grupoOptional.isPresent()){
            grupo.setId(grupoOptional.get().getId());
            grupoRepositorio.save(grupo);
            return new ResponseEntity("Grupo Actualizado", HttpStatus.OK);
        }else{
            return new ResponseEntity("Grupo No Encontrado",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Grupo> traerPorId (@Valid @PathVariable Integer id){
        Optional<Grupo> grupoOptional = grupoRepositorio.findById(id);
        if (grupoOptional.isPresent()){
            List<Equipo> equipos = (List<Equipo>) equipoRepositorio.findAll();
            for (Equipo e:equipos){
                if (equipos.size() >= 0){
                    String paisEquipo = e.getPais().getNombre();
                    e.setPaisDelEquipo(paisEquipo);
                }
            }
            return new ResponseEntity(grupoOptional,HttpStatus.OK);
        }else{
            return new ResponseEntity("Grupo No Encontrado",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(path = "nombreDelGrupo")
    public ResponseEntity<Grupo> filtrar(@RequestParam(required = false,name = "nombre")String nombre){
        List<Grupo> grupoList = listarGrupo().stream().filter(x -> x.getDescripcion().equalsIgnoreCase(nombre)).collect(Collectors.toList());
        if (grupoList.isEmpty()){
            return new ResponseEntity("Grupo No Encontrado",HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity(grupoList,HttpStatus.OK);
        }
    }
}

/*
    */