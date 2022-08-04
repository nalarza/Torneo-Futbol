package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.*;
import Torneo.Futbol.Repositorio.ArbitroRepositorio;
import Torneo.Futbol.Repositorio.EstadioRepositorio;
import Torneo.Futbol.Repositorio.JugadorRepositorio;
import Torneo.Futbol.Repositorio.PaisRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/Torneo/Paises")
public class PaisController {

    @Autowired
    PaisRepositorio paisRepositorio;
    @PostMapping(path = "/AgregarPais")
    public ResponseEntity<Pais> guardarPais(@Valid @RequestBody Pais pais){
            Pais paisGuardado = paisRepositorio.save(pais);
            URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(paisGuardado.getId()).toUri();
            return ResponseEntity.created(ubicacion).body(paisGuardado);
    }

    @GetMapping(path = "/MostrarPaises")
    public List<PaisResponse> listarPaises(){
        List<Pais> pais = (List<Pais>) paisRepositorio.findAll();
        List<PaisResponse> respuestaPais = new ArrayList<>();
        PaisResponse paisResponse = new PaisResponse();

        for (Pais p:pais){
                paisResponse.id = p.getId();
                paisResponse.nombre = p.getNombre();
                respuestaPais.add(paisResponse);
        }
        return respuestaPais;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Pais> eliminarPais(@PathVariable Integer id){
        try {
            paisRepositorio.deleteById(id);
            return new ResponseEntity("Pais Eliminado", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Pais No Encontrado, Por Favor Intentelo De Nuevo",HttpStatus.BAD_REQUEST);
        }
    }
}
