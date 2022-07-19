package Torneo.Futbol.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
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
    @JsonIgnore
    @OneToMany(mappedBy = "equipo",cascade = CascadeType.ALL)
    private List<Jugador> jugadores = new ArrayList<>();
    private String entrenador;
    private String logo;
    private String nacionalidad;

    public Equipo() {
    }

    public String getNombreDelEquipo() {
        return nombreDelEquipo;
    }

    public void setNombreDelEquipo(String nombreDelEquipo) {
        this.nombreDelEquipo = nombreDelEquipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
