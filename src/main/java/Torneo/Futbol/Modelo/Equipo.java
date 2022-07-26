package Torneo.Futbol.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

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


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipo")
    private List<Jugador> jugadores = new ArrayList<>();


    private String entrenador;
    private String logo;
    private String nacionalidad;

    public Equipo() {
    }

    public Equipo(String nombreDelEquipo, String entrenador, String nacionalidad) {
        this.nombreDelEquipo = nombreDelEquipo;
        this.entrenador = entrenador;
        this.nacionalidad = nacionalidad;
    }

    public Equipo(int id, String nombreDelEquipo, List<Jugador> jugadores, String entrenador,
                  String logo, String nacionalidad, Collection<Partido> partidos, Pais pais, Grupo grupo) {
        this.id = id;
        this.nombreDelEquipo = nombreDelEquipo;
        this.jugadores = jugadores;
        this.entrenador = entrenador;
        this.logo = logo;
        this.nacionalidad = nacionalidad;
        this.partidos = partidos;
        this.pais = pais;
        this.grupo = grupo;
    }

    public long informacion(long dinero){
        return dinero;
    }
    public String informacion(String estadio){
        return estadio;
    }


    public void setJugadores(Collection<Jugador> jugadores) {
        this.jugadores = (List<Jugador>) jugadores;
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


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipo")
    private Collection<Partido> partidos;

    public Collection<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(Collection<Partido> partidos) {
        this.partidos = partidos;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pais",nullable = false)
    private Pais pais;

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_grupo",nullable = false)
    private Grupo grupo;

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}
