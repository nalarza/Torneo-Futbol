package Torneo.Futbol.Repositorio;

import Torneo.Futbol.Modelo.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface PaisRepositorio extends JpaRepository<Pais,Integer> {
}
