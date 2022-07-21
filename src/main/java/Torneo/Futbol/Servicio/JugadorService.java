package Torneo.Futbol.Servicio;

import Torneo.Futbol.Modelo.Jugador;
import Torneo.Futbol.Repositorio.JugadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class JugadorService {
    @Autowired
    JugadorRepositorio jugadorRepositorio;
    public List<Jugador> listarJugador(){
        return (List<Jugador>) jugadorRepositorio.findAll();
    }
    public Jugador agreagrJugador (@RequestBody Jugador jugador){
        return jugadorRepositorio.save(jugador);
    }
}
