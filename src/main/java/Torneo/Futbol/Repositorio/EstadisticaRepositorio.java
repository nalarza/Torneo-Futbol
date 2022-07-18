package Torneo.Futbol.Repositorio;

import Torneo.Futbol.Modelo.Estadistica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticaRepositorio extends JpaRepository<Estadistica,Integer> {
}
