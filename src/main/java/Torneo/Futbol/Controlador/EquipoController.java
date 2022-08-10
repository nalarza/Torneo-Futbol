package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.*;
import Torneo.Futbol.Repositorio.EquipoRepositorio;
import Torneo.Futbol.Repositorio.GrupoRepositorio;
import Torneo.Futbol.Repositorio.JugadorRepositorio;
import Torneo.Futbol.Repositorio.PaisRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        JugadorResponse jugadorResponse = new JugadorResponse();
        for (Equipo e:equipos){
            if (equipos.size() >= 0){
            String paisEquipo = e.getPais().getNombre();
            e.setPaisDelEquipo(paisEquipo);
            }
            List<Jugador> jugadores = (List<Jugador>) jugadorRepositorio.findAll();
            for (Jugador j : jugadores){
               jugadorResponse.setPaisJuagdor(j.getPais().getNombre());
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
    @Autowired
    PaisRepositorio paisRepositorio;
    @Autowired
    GrupoRepositorio grupoRepositorio;
    @PutMapping(path = "/{id}")
    public ResponseEntity<Equipo> actualizarEquipo (@Valid @RequestBody Equipo equipo, @PathVariable Integer id){
        Optional<Equipo> equipoOptional = equipoRepositorio.findById(id);
        Optional<Pais> paisOptional = paisRepositorio.findById(equipo.getPais().getId());
        Optional<Grupo> grupoOptional = grupoRepositorio.findById(equipo.getGrupo().getId());
        if (equipoOptional.isPresent()){
            if (paisOptional.isPresent()){
                if (grupoOptional.isPresent()){
                    equipo.setId(equipoOptional.get().getId());
                    equipoRepositorio.save(equipo);
                    return new ResponseEntity("Equipo Actualizado",HttpStatus.OK);
                }else{
                    return new ResponseEntity("Grupo No Encontrado",HttpStatus.BAD_REQUEST);
                }
            }else{
                return new ResponseEntity("Pais No Encontrado",HttpStatus.BAD_REQUEST);
            }

        }else{
            return new ResponseEntity("Equipo No Encontrado",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(path = "/nombreDelEquipo")
    public List<Equipo > filtrar(@RequestParam (required = false, name = "nombre") String nombre) {
        List<Equipo> filtro = listarEquipos().stream().filter(x -> x.getNombre().equalsIgnoreCase(nombre)).collect(Collectors.toList());
        return filtro;
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity <Equipo> traerPorId(@Valid @PathVariable Integer id){
        Optional<Equipo> equipoOptional = equipoRepositorio.findById(id);
        if (equipoOptional.isPresent()){
            return new ResponseEntity(equipoOptional,HttpStatus.OK);
        }else{
            return new ResponseEntity("Equipo No Encontrado",HttpStatus.BAD_REQUEST);
        }
    }

}

/*
    */