package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.*;
import Torneo.Futbol.Servicio.PaisServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/Torneo/Paises")
public class PaisController {
    @Autowired
    private PaisServicio servicio;

    @PostMapping(path = "/AgregarPais")
    public ResponseEntity<Pais> guardarPais(@Valid @RequestBody Pais pais){
        return servicio.guardarPais(pais);
    }
    @GetMapping(path = "/MostrarPaises")
    public List<Pais> listarPaises(){
        return servicio.listarPaises();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Pais> eliminarPais(@PathVariable Integer id){
        return servicio.eliminarPais(id);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Pais> actualizarPais (@Valid @RequestBody Pais pais,@PathVariable Integer id){
        return servicio.actualizarPais(pais,id);
    }
    @GetMapping(path = "/nombrePais")
    public ResponseEntity<Pais> filtrar(@RequestParam (required = false, name = "nombre") String nombre) {
        return servicio.filtrar(nombre);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Pais> traerPorId (@Valid @PathVariable Integer id){
     return servicio.traerPorId(id);
    }
}