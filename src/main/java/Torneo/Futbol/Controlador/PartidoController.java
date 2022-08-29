package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.*;
import Torneo.Futbol.Servicio.PartidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/Torneo/Partido")
public class PartidoController {
    @Autowired
    private PartidoServicio servicio;

    @PostMapping(path = "/AgregarPartido")
    public ResponseEntity<Partido> guardarPartido(@Valid @RequestBody Partido partido){
        return servicio.guardarPartido(partido);
    }
    @GetMapping(path = "/MostrarPartidos")
    public List<PartidoRespuesta> listarPartidos(){
        return servicio.listarPartidos();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Partido> eliminarPartido(@PathVariable Integer id){
        return servicio.eliminarPartido(id);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Partido> actualizarPartido (@Valid @RequestBody Partido partido,@PathVariable Integer id){
        return servicio.actualizarPartido(partido, id);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Partido> TraerId(@Valid @PathVariable Integer id){
        return servicio.TraerId(id);
    }
    @GetMapping(path = "nombreDelEquipo")
    public ResponseEntity<Partido> filtrar(@RequestParam(required = false,name = "nombre")String nombre){
        return servicio.filtrar(nombre);
    }
}