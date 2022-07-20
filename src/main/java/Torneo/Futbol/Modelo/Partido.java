package Torneo.Futbol.Modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "partido")
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_partido" ,unique = true,nullable = false)
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Estadio estadio;

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Arbitro arbitro;

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partidos")
    private Collection<Estadistica> estadistica;

    public Collection<Estadistica> getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(Collection<Estadistica> estadistica) {
        this.estadistica = estadistica;
    }


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Equipo equipo;

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
