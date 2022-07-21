package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.Arbitro;
import Torneo.Futbol.Modelo.Equipo;
import Torneo.Futbol.Modelo.Jugador;
import Torneo.Futbol.Servicio.ArbitroService;
import Torneo.Futbol.Servicio.EquipoService;
import Torneo.Futbol.Servicio.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/Torneo")
public class TorneoControlador {
    @Autowired
    EquipoService equipoService;
    @PostMapping(path = "/DatosDeEquipo")
    public @ResponseBody String nuevoEquipo(@RequestBody Equipo equipo){
        equipoService.añadirEquipo(equipo);
        return "Guardado";
    }
    @GetMapping(path = "/DatosDeEquipo")
    public List<Equipo> todosLosEquipos(){
        return this.equipoService.listarEquipo();
    }

    @Autowired
    ArbitroService arbitroService;
    @PostMapping(path = "/añadirArbitro")
    public @ResponseBody String añadirArbitro(@RequestBody Arbitro arbitro){
        arbitroService.añadirArbitro(arbitro);
        return "Arbitro Añadido";
    }
    @GetMapping(path = "/datosDeArbitro")
    public List<Arbitro> listarArbitros(){
        return this.arbitroService.listarArbitros();
    }
    @DeleteMapping(path = "/elimarArbitro")
    public void eliminar(@RequestBody Arbitro arbitro){
        arbitroService.eliminar(arbitro);
    }
    @PutMapping(path = "/actualizarArbitro")
    public @ResponseBody String actualizarArbitro(@RequestBody Arbitro arbitro){
        arbitroService.actualizar(arbitro);
        return "Actualizado";
    }

    @Autowired
    JugadorService jugadorService;
    @PostMapping(path = "/añadirJugador")
    public @ResponseBody String añadirJugador (@RequestBody Jugador jugador){
        jugadorService.añadirJugador(jugador);
        return "Jugador Añadido";
    }
}
