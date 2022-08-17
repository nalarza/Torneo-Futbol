package Torneo.Futbol.Modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "estadio")
public class Estadio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadio" ,nullable = false,unique = true)
    private int id;
    private String ciudad;
    private String nombre;
    private long capacidad;

    private String paisEstadio;

    @OneToMany(mappedBy = "estadio", cascade = CascadeType.ALL)
    private Set<Partido> partidos = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_pais")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Pais pais;

    public Estadio() {
    }

    public Estadio(int id, String ciudad, String nombre, long capacidad, String paisEstadio, Set<Partido> partidos, Pais pais) {
        this.id = id;
        this.ciudad = ciudad;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.paisEstadio = paisEstadio;
        this.partidos = partidos;
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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

    public float getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(long capacidad) {
        this.capacidad = capacidad;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
