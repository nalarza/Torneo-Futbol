package Torneo.Futbol.Servicio;

import Torneo.Futbol.Modelo.Pais;
import Torneo.Futbol.Repositorio.PaisRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PaisService {
    @Autowired
    PaisRepositorio paisRepositorio;
    public List<Pais> listarPais(){
        return (List<Pais>) paisRepositorio.findAll();
    }
    public Pais añadirPais(@RequestBody Pais pais){
        return paisRepositorio.save(pais);
    }


}
