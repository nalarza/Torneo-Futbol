package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.*;
import Torneo.Futbol.Servicio.EquipoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/Torneo/Equipos")
public class EquipoController {
    @Autowired
    private EquipoServicio servicio;

    @GetMapping(path = "/MostrarEquipos")
    public List<Equipo> listarEquipos(){
       return servicio.listarEquipos();
    }
    @PostMapping(path = "/AgregarEquipo")
    public ResponseEntity<Equipo> guardarEquipo(@Valid @RequestBody Equipo equipo){
        return servicio.guardarEquipo(equipo);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Equipo> eliminarEquipo(@PathVariable Integer id){
        return servicio.eliminarEquipo(id);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Equipo> actualizarEquipo (@Valid @RequestBody Equipo equipo, @PathVariable Integer id){
        return servicio.actualizarEquipo(equipo,id);
    }
    @GetMapping(path = "/nombreDelEquipo")
    public ResponseEntity<Equipo > filtrar(@RequestParam (required = false, name = "nombre") String nombre) {
        return servicio.filtrar(nombre);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity <Equipo> traerPorId(@Valid @PathVariable Integer id){
      return servicio.traerPorId(id);
    }
}