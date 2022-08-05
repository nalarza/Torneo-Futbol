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
import java.util.Optional;

@RestController
@RequestMapping(path = "/Torneo/Paises")
public class PaisController {

    @Autowired
    PaisRepositorio paisRepositorio;
    @PostMapping(path = "/AgregarPais")
    public ResponseEntity<Pais> guardarPais(@Valid @RequestBody Pais pais){
            paisRepositorio.save(pais);
        return new ResponseEntity("Pais Guardado", HttpStatus.OK);
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
    @PutMapping(path = "/{id}")
    public ResponseEntity<Pais> actualizarPais (@Valid @RequestBody Pais pais,@PathVariable Integer id){
          Optional<Pais> paisOptional = paisRepositorio.findById(id);
          if (paisOptional.isPresent()) {
              pais.setId(paisOptional.get().getId());
              paisRepositorio.save(pais);
              return new ResponseEntity("Pais Actualizado", HttpStatus.OK);
          }else {
              return new ResponseEntity("Pais No Encontrado",HttpStatus.BAD_REQUEST);
          }
    }
}
/*  try{
          Optional<Pais> paisOptional = paisRepositorio.findById(id);
          pais.setId(paisOptional.get().getId());
          paisRepositorio.save(pais);
          return new ResponseEntity("Pais Actualizado",HttpStatus.OK);
      }catch (Exception e){
          return new ResponseEntity("Pais No Encontrado",HttpStatus.BAD_REQUEST);
      }
 */