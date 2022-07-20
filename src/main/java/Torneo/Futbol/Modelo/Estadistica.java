package Torneo.Futbol.Modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "estadistica")
public class Estadistica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadistica" ,unique = true,nullable = false)
    private int id;
    private String descripcion;
    @Column(name = "minuto_de_juego")
    private String minutoDeJuego;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMinutoDeJuego() {
        return minutoDeJuego;
    }

    public void setMinutoDeJuego(String minutoDeJuego) {
        this.minutoDeJuego = minutoDeJuego;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Partido partidos;

    public Partido getPartidos() {
        return partidos;
    }

    public void setPartidos(Partido partidos) {
        this.partidos = partidos;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadistica")
    private Collection<Evento> evento;

    public Collection<Evento> getEvento() {
        return evento;
    }

    public void setEvento(Collection<Evento> evento) {
        this.evento = evento;
    }
}
