package Torneo.Futbol.Modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais" ,unique = true,nullable = false)
    private int id;
    private String nombre;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    private Set<Equipo> equipos = new HashSet<>();

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    private Set<Jugador> jugadores = new HashSet<>();

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    private Set<Arbitro> arbitros = new HashSet<>();

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    private Set<Estadio> estadios = new HashSet<>();

    public Pais() {
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


    public void setEstadios(Set<Estadio> estadios) {
        this.estadios = estadios;
        for (Estadio estadio:estadios){
            estadio.setPais(this);
        }
    }

    public void setArbitros(Set<Arbitro> arbitros) {
        this.arbitros = arbitros;
        for (Arbitro arbitro: arbitros){
            arbitro.setPais(this);
        }
    }

    public void setJugadores(Set<Jugador> jugadores) {
        this.jugadores = jugadores;
        for(Jugador jugador:jugadores){
            jugador.setPais(this);
        }
    }

    public void setEquipos(Set<Equipo> equipos) {
        this.equipos = equipos;
        for (Equipo equipo: equipos){
            equipo.setPais(this);
        }
    }

}
/*

*/