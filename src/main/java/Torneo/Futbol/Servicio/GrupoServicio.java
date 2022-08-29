package Torneo.Futbol.Servicio;

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
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GrupoServicio {

    @Autowired
    private GrupoRepositorio grupoRepositorio;

    @Autowired
    EquipoRepositorio equipoRepositorio;

    @Autowired
    JugadorRepositorio jugadorRepositorio;

    public ResponseEntity<Grupo> guardarGrupo(@Valid @RequestBody Grupo grupo) {
        grupoRepositorio.save(grupo);
        return new ResponseEntity("Grupo Guardado", HttpStatus.OK);
    }

    public List<Grupo> listarGrupo(){
        List<Grupo> grupos =  grupoRepositorio.findAll();
        JugadorResponse jugadorResponse = new JugadorResponse();
        paisDeEquipo();
        paisDelJugador(jugadorResponse);
        return grupos;
    }

    private void paisDelJugador(JugadorResponse jugadorResponse) {
        List<Jugador> jugadores = (List<Jugador>) jugadorRepositorio.findAll();
        for (Jugador j : jugadores){
            jugadorResponse.setPaisJuagdor(j.getPais().getNombre());
        }
    }

    private void paisDeEquipo() {
        List<Equipo> equipos = (List<Equipo>) equipoRepositorio.findAll();
        for (Equipo e:equipos){
            if (equipos.size() >= 0){
                String paisEquipo = e.getPais().getNombre();
                e.setPaisDelEquipo(paisEquipo);
            }
        }
    }

    public ResponseEntity<Grupo> eliminarGrupo(@PathVariable Integer id){
        try{
            grupoRepositorio.deleteById(id);
            return new ResponseEntity("Grupo Eliminado",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Grupo No Encontrado, Por Favor Intentelo De Nuevo",HttpStatus.BAD_REQUEST);
        }
    }

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

    public ResponseEntity<Grupo> traerPorId (@Valid @PathVariable Integer id) {
        Optional<Grupo> grupoOptional = grupoRepositorio.findById(id);
        if (grupoOptional.isPresent()) {
            paisDeEquipo();
            return new ResponseEntity(grupoOptional, HttpStatus.OK);
        } else {
            return new ResponseEntity("Grupo No Encontrado", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Grupo> filtrar(@RequestParam(required = false,name = "nombre")String nombre){
        List<Grupo> grupoList = listarGrupo().stream().filter(x -> x.getDescripcion().equalsIgnoreCase(nombre)).collect(Collectors.toList());
        if (grupoList.isEmpty()){
            return new ResponseEntity("Grupo No Encontrado",HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity(grupoList,HttpStatus.OK);
        }
    }
}
