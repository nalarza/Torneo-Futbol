package Torneo.Futbol.Modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    private int minutoDeJuego;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_evento")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Evento evento;

    public Estadistica() {
    }

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

    public int getMinutoDeJuego() {
        return minutoDeJuego;
    }

    public void setMinutoDeJuego(int minutoDeJuego) {
        this.minutoDeJuego = minutoDeJuego;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}