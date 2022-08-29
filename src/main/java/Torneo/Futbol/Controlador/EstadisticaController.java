package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.Estadistica;
import Torneo.Futbol.Servicio.EstadisticaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/Torneo/Estadistica")
public class EstadisticaController {
    @Autowired
    private EstadisticaServicio servicio;

    @GetMapping(path = "/MostrarEstadisticas")
    public List<Estadistica> listarEstadisticas(){
        return servicio.listarEstadisticas();
    }
    @PostMapping(path = "/AgregarEstadistica")
    public ResponseEntity<Estadistica> guardarEstadistica(@Valid @RequestBody Estadistica estadistica){
        return servicio.guardarEstadistica(estadistica);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Estadistica> eliminarEstadistica(@PathVariable Integer id){
        return servicio.eliminarEstadistica(id);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Estadistica> actualizarEstadistica (@Valid @RequestBody Estadistica estadistica,@PathVariable Integer id){
        return servicio.actualizarEstadistica(estadistica, id);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Estadistica> traerId(@Valid @PathVariable Integer id){
        return servicio.traerId(id);
    }
}