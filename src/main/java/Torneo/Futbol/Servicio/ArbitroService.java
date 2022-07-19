package Torneo.Futbol.Servicio;

import Torneo.Futbol.Modelo.Arbitro;
import Torneo.Futbol.Repositorio.ArbitroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ArbitroService {
    @Autowired
    ArbitroRepositorio arbitroRepositorio;

    public List<Arbitro> listarArbitros(){
        return (List<Arbitro>) arbitroRepositorio.findAll();
    }
    public Arbitro añadirArbitro (@RequestBody Arbitro arbitro){
        return arbitroRepositorio.save(arbitro);
    }

}
