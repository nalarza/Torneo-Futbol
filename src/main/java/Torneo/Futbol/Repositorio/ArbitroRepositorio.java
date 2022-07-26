package Torneo.Futbol.Repositorio;

import Torneo.Futbol.Modelo.Arbitro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArbitroRepositorio extends JpaRepository<Arbitro,Integer> {
    //prueba
}
