package Torneo.Futbol.Repositorio;

import Torneo.Futbol.Modelo.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepositorio extends JpaRepository<Evento,Integer> {
}
