package Torneo.Futbol.Repositorio;

import Torneo.Futbol.Modelo.Estadio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadioRepositorio extends JpaRepository<Estadio,Integer> {
}
