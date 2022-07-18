package Torneo.Futbol.Modelo;

import javax.persistence.*;

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
}
