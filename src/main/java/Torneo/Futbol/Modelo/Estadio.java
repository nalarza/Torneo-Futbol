package Torneo.Futbol.Modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "estadio")
public class Estadio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadio" ,nullable = false,unique = true)
    private int id;
    private String nombre;
    private String capacidad;

    private String paisEstadio;

    @OneToMany(mappedBy = "estadio", cascade = CascadeType.ALL)
    private Set<Partido> partidos = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_pais")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Pais pais;

    public Estadio() {
    }

    public Estadio(int id, String nombre, String capacidad, Pais pais) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.pais = pais;
    }

    public Set<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(Set<Partido> partidos) {
        this.partidos = partidos;
        for (Partido partido:partidos){
            partido.setEstadio(this);
        }
    }

    public String getPaisEstadio() {
        return paisEstadio;
    }

    public void setPaisEstadio(String paisEstadio) {
        this.paisEstadio = paisEstadio;
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

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
