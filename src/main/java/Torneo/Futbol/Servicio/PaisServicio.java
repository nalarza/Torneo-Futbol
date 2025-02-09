package Torneo.Futbol.Servicio;

import Torneo.Futbol.Modelo.Pais;
import Torneo.Futbol.Repositorio.PaisRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaisServicio {
    @Autowired
    PaisRepositorio paisRepositorio;

    public ResponseEntity<Pais> guardarPais(@Valid @RequestBody Pais pais){
        paisRepositorio.save(pais);
        return new ResponseEntity("Pais Guardado", HttpStatus.OK);
    }

    public List<Pais> listarPaises(){
        List<Pais> pais = (List<Pais>) paisRepositorio.findAll();
        return pais;
    }

    public ResponseEntity<Pais> eliminarPais(@PathVariable Integer id){
        try {
            paisRepositorio.deleteById(id);
            return new ResponseEntity("Pais Eliminado", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Pais No Encontrado, Por Favor Intentelo De Nuevo",HttpStatus.BAD_REQUEST);
        }
    }

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

    public ResponseEntity<Pais> filtrar(@RequestParam(required = false, name = "nombre") String nombre) {
        List<Pais> PaisOptional = listarPaises().stream().filter(x -> x.getNombre().equalsIgnoreCase(nombre)).collect(Collectors.toList());
        if (PaisOptional.isEmpty()){
            return new ResponseEntity("Pais No Encontrado",HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity(PaisOptional,HttpStatus.OK);
        }
    }

    public ResponseEntity<Pais> traerPorId (@Valid @PathVariable Integer id){
        Optional<Pais> paisOptional = paisRepositorio.findById(id);
        if (paisOptional.isPresent()){
            return new ResponseEntity(paisOptional,HttpStatus.OK);
        }else{
            return new ResponseEntity("Pais No Encontrado",HttpStatus.BAD_REQUEST);
        }
    }
}
