package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.Jugador;
import Torneo.Futbol.Modelo.Pais;
import Torneo.Futbol.Repositorio.PaisRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

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
    public ResponseEntity<Iterable<Pais>> listarPaises(){
        return ResponseEntity.ok(paisRepositorio.findAll());
    }
}
