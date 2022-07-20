package Torneo.Futbol.Modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "estadio")
public class Estadio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadio" ,nullable = false,unique = true)
    private int id;
    private String nombre;
    private String capacidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadio")
    private Collection<Partido> partidos;

    public Collection<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(Collection<Partido> partidos) {
        this.partidos = partidos;
    }
}
