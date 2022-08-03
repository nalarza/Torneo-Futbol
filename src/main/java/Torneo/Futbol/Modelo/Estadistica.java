package Torneo.Futbol.Modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "estadistica")
public class Estadistica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadistica" ,unique = true,nullable = false)
    private int id;
    private String descripcion;
    @Column(name = "minuto_de_juego")
    private int minutoDeJuego;

}
