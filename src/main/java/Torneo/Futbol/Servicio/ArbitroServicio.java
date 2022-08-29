package Torneo.Futbol.Servicio;

import Torneo.Futbol.Modelo.Arbitro;
import Torneo.Futbol.Modelo.Pais;
import Torneo.Futbol.Repositorio.ArbitroRepositorio;
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
public class ArbitroServicio {
    @Autowired
    ArbitroRepositorio arbitroRepositorio;
    @Autowired
    PaisRepositorio paisRepositorio;

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

    public ResponseEntity<Arbitro> guardarArbitro(@Valid @RequestBody Arbitro arbitro){
        try{
            arbitroRepositorio.save(arbitro);
            return new ResponseEntity("Arbitro Agregado", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("El pais no existe",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Arbitro> eliminarArbitro(@PathVariable Integer id){
        try{
            arbitroRepositorio.deleteById(id);
            return new ResponseEntity("Arbitro Eliminado",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Arbitro No Encontrado, Por Favor Intentelo De Nuevo",HttpStatus.BAD_REQUEST);
        }
    }

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

    public ResponseEntity<Arbitro> filtrar(@RequestParam(required = false,name = "nombre")String nombre){
        List<Arbitro> arbitroList = listarArbitros().stream().filter(x -> x.getNombre().equalsIgnoreCase(nombre)).collect(Collectors.toList());
        if (arbitroList.isEmpty()){
            return  new ResponseEntity("Arbitro No Encontrado",HttpStatus.BAD_REQUEST);
        }else{
            return  new ResponseEntity(arbitroList,HttpStatus.OK);
        }
    }
}
