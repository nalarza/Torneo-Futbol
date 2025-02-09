package Torneo.Futbol.Modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "arbitro")
public class Arbitro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arbitro" ,unique = true,nullable = false)
    private int id;
    private  String nombre;

    private String paisArbitro;

    @OneToMany(mappedBy = "arbitro", cascade = CascadeType.ALL)
    private Set<Partido> partidos = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_pais")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Pais pais;

    public Arbitro() {
    }

    public Arbitro(int id, String nombre, Pais pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
    }

    public Arbitro(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisArbitro() {
        return paisArbitro;
    }

    public void setPaisArbitro(String paisArbitro) {
        this.paisArbitro = paisArbitro;
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

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
