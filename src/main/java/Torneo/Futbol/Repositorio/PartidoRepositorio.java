package Torneo.Futbol.Repositorio;

import Torneo.Futbol.Modelo.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepositorio extends JpaRepository<Partido,Integer> {
}
