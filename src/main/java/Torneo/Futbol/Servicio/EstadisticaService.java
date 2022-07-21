package Torneo.Futbol.Servicio;

import Torneo.Futbol.Modelo.Estadistica;
import Torneo.Futbol.Repositorio.EstadisticaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EstadisticaService {
    @Autowired
    EstadisticaRepositorio estadisticaRepositorio;
    public List<Estadistica> listarEstadisticas(){
        return estadisticaRepositorio.findAll();
    }
    public Estadistica agregarEstadisticas(@RequestBody Estadistica estadistica){
        return estadisticaRepositorio.save(estadistica);
    }
}
