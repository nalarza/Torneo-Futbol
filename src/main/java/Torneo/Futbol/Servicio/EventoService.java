package Torneo.Futbol.Servicio;

import Torneo.Futbol.Modelo.Evento;
import Torneo.Futbol.Repositorio.EventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EventoService {
    @Autowired
    EventoRepositorio eventoRepositorio;
    public List<Evento> listarEvento(){
        return (List<Evento>) eventoRepositorio.findAll();
    }
    public Evento añadirEvento(@RequestBody Evento evento){
        return eventoRepositorio.save(evento);
    }
}
