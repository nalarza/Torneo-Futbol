package Torneo.Futbol.Servicio;

import Torneo.Futbol.Modelo.Partido;
import Torneo.Futbol.Repositorio.PartidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PartidoService {
    @Autowired
    PartidoRepositorio partidoRepositorio;
    public List<Partido> listarPartodos(){
        return (List<Partido>) partidoRepositorio.findAll();
    }
    public Partido agregarPartido (@RequestBody Partido partido){
        return partidoRepositorio.save(partido);
    }
}
