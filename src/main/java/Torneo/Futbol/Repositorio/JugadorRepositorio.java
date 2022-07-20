package Torneo.Futbol.Repositorio;

import Torneo.Futbol.Modelo.Jugador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JugadorRepositorio extends CrudRepository<Jugador,Integer> {
}
