package Torneo.Futbol.Servicio;

import Torneo.Futbol.Modelo.Grupo;
import Torneo.Futbol.Repositorio.GrupoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class GrupoService {
    @Autowired
    GrupoRepositorio grupoRepositorio;
    public List<Grupo> listarGrupos(){
        return (List<Grupo>) grupoRepositorio.findAll();
    }
    public Grupo añadirGrupo(@RequestBody Grupo grupo){
        return grupoRepositorio.save(grupo);
    }
}
