package Torneo.Futbol.Modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "equipo")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo",unique = true,nullable = false)
    private int id;
    @Column(name = "nombre")
    private String nombreDelEquipo;
    private String entrenador;
    private String logo;
    private String nacionalidad;

}
