package Torneo.Futbol.Servicio;

import Torneo.Futbol.Modelo.Equipo;
import Torneo.Futbol.Repositorio.EquipoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EquipoService {
    @Autowired
    EquipoRepositorio equipoRepositorio;
    public List<Equipo> listarEquipo(){
        return (List<Equipo>) equipoRepositorio.findAll();
    }
    public Equipo añadirEquipo (@RequestBody Equipo equipo){
        return equipoRepositorio.save(equipo);
    }
}
