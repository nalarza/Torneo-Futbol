package Torneo.Futbol.Servicio;

import Torneo.Futbol.Modelo.Estadio;
import Torneo.Futbol.Repositorio.EstadioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EstadioService {
    @Autowired
    EstadioRepositorio estadioRepositorio;
    public List<Estadio> listarEstadio(){
        return (List<Estadio>) estadioRepositorio.findAll();
    }
    public Estadio agregarEstadio(@RequestBody Estadio estadio){
        return estadioRepositorio.save(estadio);
    }
}
