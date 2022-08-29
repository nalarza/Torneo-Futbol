package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.*;
import Torneo.Futbol.Servicio.EstadioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/Torneo/Estadio")
public class EstadioController {
    @Autowired
    private EstadioServicio servicio;

    @GetMapping(path = "/MostrarEstadios")
    public List<Estadio> listarEstadio(){
        return servicio.listarEstadio();
    }
    @PostMapping(path = "/AgregarEstadio")
    public ResponseEntity<Estadio> guardarEstadio(@Valid @RequestBody Estadio estadio){
        return servicio.guardarEstadio(estadio);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Estadio> eliminarEstadio(@PathVariable Integer id){
        return servicio.eliminarEstadio(id);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Estadio> estadiosActualizado(@Valid @RequestBody Estadio estadio,@PathVariable Integer id){
        return servicio.estadiosActualizado(estadio,id);
    }
    @GetMapping(path = "/nombreDelEstadio")
    public List<Estadio> filtrar (@RequestParam (required = false, name = "nombre") String nombre) {
        return servicio.filtrar(nombre);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Estadio> traerPorId (@Valid @PathVariable Integer id){
        return servicio.traerPorId(id);
    }
}