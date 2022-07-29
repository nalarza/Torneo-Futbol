package Torneo.Futbol.Modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "equipo")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo",unique = true,nullable = false)
    private int id;
    @NotNull
    private String nombre;
    private String entrenador;
    private String logo;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private Set<Jugador> jugadores = new HashSet<>();

    public Equipo() {
    }

    public Equipo(int id, String nombre, String entrenador, String logo, Set<Jugador> jugadores) {
        this.id = id;
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.logo = logo;
        this.jugadores = jugadores;
    }

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

    public Set<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Set<Jugador> jugadores) {
        this.jugadores = jugadores;
        for (Jugador jugador: jugadores){
            jugador.setEquipo(this);
        }
    }
}
