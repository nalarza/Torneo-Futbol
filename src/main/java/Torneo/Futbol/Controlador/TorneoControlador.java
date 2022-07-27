package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.*;
import Torneo.Futbol.Servicio.ArbitroService;
import Torneo.Futbol.Servicio.EquipoService;
import Torneo.Futbol.Servicio.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "/Torneo")
public class TorneoControlador {
    @Autowired
    EquipoService equipoService;
    @PostMapping(path = "/agregarDeEquipo",consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String nuevoEquipo(@RequestBody EquipoRequest equipoRequest){
        Equipo equipo = new Equipo();
        equipo.setNombreDelEquipo(equipoRequest.nombreDelEquipo);
        equipo.setEntrenador(equipoRequest.entrenador);
        equipo.setLogo(equipoRequest.logo);
        equipo.setNacionalidad(equipoRequest.nacionalidad);
        equipo.setPais(equipoRequest.pais);
        equipo.setGrupo(equipoRequest.grupo);
        equipoService.agregarEquipo(equipo);
        return "Guardado";
    }
    @GetMapping(path = "/DatosDeEquipo")
    public List<Equipo> todosLosEquipos(){
        return this.equipoService.listarEquipo();
    }


    @Autowired
    ArbitroService arbitroService;
    @PostMapping(path = "/agregarArbitro", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String agregarArbitro(@RequestBody Arbitro arbitro){
        arbitroService.agregarArbitro(arbitro);
        return "Agregado";
    }
    @GetMapping(path = "/datosDeArbitro")
    public List<Arbitro> listarArbitros(){
        return this.arbitroService.listarArbitros();
    }
    @DeleteMapping(path = "/eliminarArbitro/Id")
    public void eliminarId(@PathVariable("id") Integer id){
        arbitroService.eliminarId(id);
    }
    @PutMapping(path = "/actualizarArbitro")
    public @ResponseBody String actualizarArbitro(@RequestBody Arbitro arbitro) {
        arbitroService.actualizar(arbitro);
        return "Actualizado";
    }

    @Autowired
    JugadorService jugadorService;
    @PostMapping(path = "/agregarJugador",consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String añadirJugador (@RequestBody Jugador jugador){
        jugadorService.agreagrJugador(jugador);
        return "Jugador Agregado";
    }
    @GetMapping(path = "/datosDeJugadores")
    public List<Jugador> listarJugadores(){
        return this.jugadorService.listarJugador();
    }

    @GetMapping(path = "/prueba")
    public Detalles detalles(){
        Detalles det = new Detalles();
        det.setNombreDelEquipo("Atletico De Madrid");
        det.setEntrenador("Nelson Alarza");
        det.setLogo("Logotipo");
        det.setCiudad("Madrid");
        det.informacion("Bernabeu");
        det.informacion(1000);
        det.setMoneda("EURO");
        det.setNacionalidad("España");
        return det;
    }

}
