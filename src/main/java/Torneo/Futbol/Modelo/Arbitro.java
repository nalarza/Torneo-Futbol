package Torneo.Futbol.Modelo;

import javax.persistence.*;


@Entity
@Table(name = "arbitro")
public class Arbitro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arbitro" ,unique = true,nullable = false)
    private int id;
    private  String nombre;
    private String procedencia;






}
