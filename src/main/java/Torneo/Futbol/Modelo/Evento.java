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

}
