package Torneo.Futbol.Modelo;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.Collection;

@Entity
@Table(name = "pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais" ,unique = true,nullable = false)
    private int id;
    private String nombre;

}
