package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.Grupo;
import Torneo.Futbol.Servicio.GrupoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/Torneo/Grupos")
public class GrupoController {

    @Autowired
    private GrupoServicio servicio;

    @GetMapping(path = "/MostrarGrupos")
    public List<Grupo> listarGrupo(){
        return servicio.listarGrupo();
    }

    @PostMapping(path = "/AgregarGrupo")
    public ResponseEntity<Grupo> guardarGrupo(@Valid @RequestBody Grupo grupo){
        return servicio.guardarGrupo(grupo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Grupo> eliminarGrupo(@PathVariable Integer id){
        return servicio.eliminarGrupo(id);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Grupo> actualizarGrupo(@Valid @RequestBody Grupo grupo, @PathVariable Integer id){
        return servicio.actualizarGrupo(grupo,id);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Grupo> traerPorId (@Valid @PathVariable Integer id){
        return servicio.traerPorId(id);
    }
    @GetMapping(path = "/nombreDelGrupo")
    public ResponseEntity<Grupo> filtrar(@RequestParam(required = false,name = "nombre")String nombre){
        return servicio.filtrar(nombre);
    }
}
