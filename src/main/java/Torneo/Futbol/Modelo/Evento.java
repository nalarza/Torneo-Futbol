package Torneo.Futbol.Modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento" ,unique = true,nullable = false)
    private int id;
    @Column(name = "evento_de_juego")
    private String eventoDeJuego;


    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_partido")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Partido partido;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private Set<Estadistica> estadisticas = new HashSet<>();

    public Evento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventoDeJuego() {
        return eventoDeJuego;
    }

    public void setEventoDeJuego(String eventoDeJuego) {
        this.eventoDeJuego = eventoDeJuego;
    }

    public Partido getPartido(Partido partido) {
        return this.partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Set<Estadistica> getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(Set<Estadistica> estadisticas) {
        this.estadisticas = estadisticas;
        for (Estadistica estadistica:estadisticas){
            estadistica.setEvento(this);
        }
    }
}
