package Torneo.Futbol.Modelo;

import javax.persistence.*;

@Entity
@Table(name = "jugador")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador",unique = true,nullable = false)
    private int id;
    private String nombre;
    private String apellido;
    private String numero;

}
