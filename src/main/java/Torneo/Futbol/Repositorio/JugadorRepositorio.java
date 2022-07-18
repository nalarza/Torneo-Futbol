package Torneo.Futbol.Repositorio;

import Torneo.Futbol.Modelo.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepositorio extends JpaRepository<Jugador,Integer> {
}
