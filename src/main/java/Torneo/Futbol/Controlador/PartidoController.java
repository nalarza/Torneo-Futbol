package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.*;
import Torneo.Futbol.Repositorio.ArbitroRepositorio;
import Torneo.Futbol.Repositorio.EquipoRepositorio;
import Torneo.Futbol.Repositorio.EstadioRepositorio;
import Torneo.Futbol.Repositorio.PartidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Torneo/Partido")
public class PartidoController {

    @Autowired
    PartidoRepositorio partidoRepositorio;

    @PostMapping(path = "/AgregarPartido")
    public ResponseEntity<Partido> guardarPartido(@Valid @RequestBody Partido partido){
            partidoRepositorio.save(partido);
        return new ResponseEntity("Partido Guardado", HttpStatus.OK);
    }

    @GetMapping(path = "/MostrarPartidos")
    public List<PartidoRespuesta> listarPartidos(){
        List<PartidoRespuesta> partidoRespuestas = new ArrayList<>();
        List<Partido> partidos = partidoRepositorio.findAll();
        PartidoRespuesta respuesta = new PartidoRespuesta();

        for (Partido p:partidos){
                respuesta.setId(p.getId());
                respuesta.setPaisDelEstadio(p.getEstadio().getPais().getNombre());
                respuesta.setNombreDelEstadio(p.getEstadio().getNombre());
                respuesta.setEquipoLocal(p.getEquipoUno().getNombre());
                respuesta.setEquipoVisitante(p.getEquipoDos().getNombre());
                respuesta.setNombreDelArbitro(p.getArbitro().getNombre());
                respuesta.setPaisDelArbitro(p.getArbitro().getPais().getNombre());
                partidoRespuestas.add(respuesta);
        }

        return partidoRespuestas;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Partido> eliminarPartido(@PathVariable Integer id){
        try {
            partidoRepositorio.deleteById(id);
            return new ResponseEntity("Partido Eliminado", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Partido No Encontrado, Por Favor Intentelo De Nuevo",HttpStatus.BAD_REQUEST);
        }
    }
    @Autowired
    ArbitroRepositorio arbitroRepositorio;
    @Autowired
    EstadioRepositorio estadioRepositorio;
    @Autowired
    EquipoRepositorio equipoRepositorio;
    @PutMapping(path = "/{id}")
    public ResponseEntity<Partido> actualizarPartido (@Valid @RequestBody Partido partido,@PathVariable Integer id){
          Optional<Partido> partidoOptional = partidoRepositorio.findById(id);
          Optional<Arbitro> arbitroOptional = arbitroRepositorio.findById(partido.getArbitro().getId());
          Optional<Estadio> estadioOptional = estadioRepositorio.findById(partido.getArbitro().getId());
          Optional<Equipo> equipoUno = equipoRepositorio.findById(partido.getEquipoUno().getId());
          Optional<Equipo> equipoDos = equipoRepositorio.findById(partido.getEquipoDos().getId());
          if (partidoOptional.isPresent()) {
              if (arbitroOptional.isPresent()){
                  if (estadioOptional.isPresent()){
                      if (equipoUno.isPresent()){
                          if (equipoDos.isPresent()){
                                partido.setArbitro(arbitroOptional.get());
                                partido.setEstadio(estadioOptional.get());
                                partido.setEquipoUno(equipoUno.get());
                                partido.setEquipoDos(equipoDos.get());
                                partido.setId(partidoOptional.get().getId());
                                partidoRepositorio.save(partido);
                              return new ResponseEntity("Partido Actualizado",HttpStatus.OK);

                          }else{
                              return new ResponseEntity("Segundo Equipo No Encontrado",HttpStatus.BAD_REQUEST);
                          }
                      }else{
                          return new ResponseEntity("Primer Equipo No Encontrado",HttpStatus.BAD_REQUEST);
                      }
                  }else{
                      return new ResponseEntity("Estadio No Encontrado",HttpStatus.BAD_REQUEST);
                  }
              }else{
                  return new ResponseEntity("Arbitro No Encontrado",HttpStatus.BAD_REQUEST);
              }
          }else {
              return new ResponseEntity("Partido No Encontrado",HttpStatus.BAD_REQUEST);
          }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Partido> TraerId(@Valid @PathVariable Integer id){
        Optional<Partido> partidoOptional = partidoRepositorio.findById(id);
        List<PartidoRespuesta> respuestas = new ArrayList<>();
        PartidoRespuesta partidoRespuesta = new PartidoRespuesta();
        if (partidoOptional.isPresent()){
                partidoRespuesta.setId(partidoOptional.get().getId());
                partidoRespuesta.setPaisDelArbitro(partidoOptional.get().getArbitro().getPais().getNombre());
                partidoRespuesta.setPaisDelEstadio(partidoOptional.get().getEstadio().getPais().getNombre());
                partidoRespuesta.setNombreDelArbitro(partidoOptional.get().getArbitro().getNombre());
                partidoRespuesta.setEquipoLocal(partidoOptional.get().getEquipoUno().getNombre());
                partidoRespuesta.setEquipoVisitante(partidoOptional.get().getEquipoDos().getNombre());
                partidoRespuesta.setNombreDelEstadio(partidoOptional.get().getEstadio().getNombre());
                respuestas.add(partidoRespuesta);
            return new ResponseEntity(respuestas,HttpStatus.OK);
        }else{
            return new ResponseEntity("Partido No Encontrado",HttpStatus.BAD_REQUEST);
        }
    }
}
/*
 */