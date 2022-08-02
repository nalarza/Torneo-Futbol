package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.Equipo;
import Torneo.Futbol.Repositorio.EquipoRepositorio;
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

    @GetMapping(path = "/MostrarEquipos")
    public List<Equipo> listarEquipos(){
        List<Equipo> equipos = (List<Equipo>) equipoRepositorio.findAll();
        for (Equipo e:equipos){
            if (equipos.size() >= 0){
            String paisEquipo = e.getPais().getNombre();
            e.setPaisDelEquipo(paisEquipo);
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