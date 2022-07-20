package Torneo.Futbol.Modelo;

import javax.persistence.*;

@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento" ,unique = true,nullable = false)
    private int id;
    @Column(name = "evento_de_juego")
    private String eventoDeJuego;

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

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Estadistica estadistica;

    public Estadistica getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(Estadistica estadistica) {
        this.estadistica = estadistica;
    }
}
