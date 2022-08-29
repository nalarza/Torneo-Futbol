package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.Arbitro;
import Torneo.Futbol.Servicio.ArbitroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/Torneo/Arbitro")
public class ArbitroController {

    @Autowired
    private ArbitroServicio servicio;

    @GetMapping(path = "/MostrarArbitros")
    public List<Arbitro> listarArbitros(){
        return servicio.listarArbitros();
    }
    @PostMapping(path = "/AgregarArbitro")
    public ResponseEntity<Arbitro> guardarArbitro(@Valid @RequestBody Arbitro arbitro){
        return servicio.guardarArbitro(arbitro);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Arbitro> eliminarArbitro(@PathVariable Integer id){
        return servicio.eliminarArbitro(id);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Arbitro> actualizarArbitro(@Valid @RequestBody Arbitro arbitro,@PathVariable Integer id){
        return servicio.actualizarArbitro(arbitro,id);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Arbitro> traerPorId (@Valid @PathVariable Integer id){
        return servicio.traerPorId(id);
    }
    @GetMapping(path = "/nombreDelArbitro")
    public ResponseEntity<Arbitro> filtrar(@RequestParam(required = false,name = "nombre")String nombre){
        return servicio.filtrar(nombre);
    }
}
