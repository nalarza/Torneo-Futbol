package Torneo.Futbol.Modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    private String paisDelEquipo;



    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private Set<Jugador> jugadores = new HashSet<>();

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private Set<Partido> partidos = new HashSet<>();


    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_pais")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Pais pais;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_grupo")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Grupo grupo;



    public Equipo() {
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Equipo(int id, String nombre, String entrenador, String logo, Set<Jugador> jugadores, Pais pais) {
        this.id = id;
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.logo = logo;
        this.jugadores = jugadores;
        this.pais = pais;
    }
    public String getPaisDelEquipo() {
        return paisDelEquipo;
    }

    public void setPaisDelEquipo(String paisDelEquipo) {
        this.paisDelEquipo = paisDelEquipo;
    }
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
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

    public Set<Partido> getPartidos() {
        return partidos;
    }


    public void setPartidos(Set<Partido> partidos) {
        this.partidos = partidos;
        for (Partido partido: partidos){
            partido.setEquipo(this);
        }
    }

    public void setJugadores(Set<Jugador> jugadores) {
        this.jugadores = jugadores;
        for (Jugador jugador: jugadores){
            jugador.setEquipo(this);
        }
    }

}
