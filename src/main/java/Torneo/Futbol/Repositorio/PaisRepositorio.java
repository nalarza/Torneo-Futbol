package Torneo.Futbol.Repositorio;

import Torneo.Futbol.Modelo.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepositorio extends CrudRepository<Pais,Integer> {
}
