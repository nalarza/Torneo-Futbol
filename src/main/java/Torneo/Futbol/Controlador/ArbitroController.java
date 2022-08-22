package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.Arbitro;
import Torneo.Futbol.Modelo.Jugador;
import Torneo.Futbol.Modelo.Pais;
import Torneo.Futbol.Repositorio.ArbitroRepositorio;
import Torneo.Futbol.Repositorio.PaisRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/Torneo/Arbitro")
public class ArbitroController {

    @Autowired
    ArbitroRepositorio arbitroRepositorio;
    @Autowired
    PaisRepositorio paisRepositorio;
    @GetMapping(path = "/MostrarArbitros")
    public List<Arbitro> listarArbitros(){
        List<Arbitro> arbitros =  arbitroRepositorio.findAll();
        for (Arbitro a:arbitros){
            if (arbitros.size() >= 0) {
               String pais = a.getPais().getNombre();
               a.setPaisArbitro(pais);
            }
        }
        return arbitros;
    }

    @PostMapping(path = "/AgregarArbitro")
    public ResponseEntity<Arbitro> guardarArbitro(@Valid @RequestBody Arbitro arbitro){
        try{
            arbitroRepositorio.save(arbitro);
            return new ResponseEntity("Arbitro Agregado",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("El pais no existe",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Arbitro> eliminarArbitro(@PathVariable Integer id){
      try{
          arbitroRepositorio.deleteById(id);
          return new ResponseEntity("Arbitro Eliminado",HttpStatus.OK);
      }catch (Exception e){
          return new ResponseEntity("Arbitro No Encontrado, Por Favor Intentelo De Nuevo",HttpStatus.BAD_REQUEST);
      }
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Arbitro> actualizarArbitro(@Valid @RequestBody Arbitro arbitro,@PathVariable Integer id){
        Optional<Arbitro> arbitroOptional = arbitroRepositorio.findById(id);
        Optional<Pais> paisOptional = paisRepositorio.findById(arbitro.getPais().getId());
        if (arbitroOptional.isPresent()){
            if (paisOptional.isPresent()){
                arbitro.setPais(paisOptional.get());
                arbitro.setId(arbitroOptional.get().getId());
                arbitroRepositorio.save(arbitro);
                return new ResponseEntity("Arbitro Actualizado",HttpStatus.OK);
            }else {
                return new ResponseEntity("Pais No Encontrado",HttpStatus.BAD_REQUEST);
            }
        }else {
          return new ResponseEntity("Arbitro No Encontrado",HttpStatus.BAD_REQUEST);

        }
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Arbitro> traerPorId (@Valid @PathVariable Integer id){
        Optional<Arbitro> arbitroOptional = arbitroRepositorio.findById(id);
        if (arbitroOptional.isPresent()){
            List<Arbitro> arbitroList = listarArbitros();
            for (Arbitro a : arbitroList){
                String pais = a.getPaisArbitro();
                arbitroOptional.get().setPaisArbitro(pais);
            }
            return new ResponseEntity(arbitroOptional,HttpStatus.OK);
        }else{
            return new ResponseEntity("Arbitro No Encontrado",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(path = "/nombreDelArbitro")
    public ResponseEntity<Arbitro> filtrar(@RequestParam(required = false,name = "nombre")String nombre){
        List<Arbitro> arbitroList = listarArbitros().stream().filter(x -> x.getNombre().equalsIgnoreCase(nombre)).collect(Collectors.toList());
        if (arbitroList.isEmpty()){
            return  new ResponseEntity("Arbitro No Encontrado",HttpStatus.BAD_REQUEST);
        }else{
            return  new ResponseEntity(arbitroList,HttpStatus.OK);
        }
    }
}

/*
    */