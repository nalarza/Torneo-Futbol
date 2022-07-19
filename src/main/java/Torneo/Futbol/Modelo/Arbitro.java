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

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }
}
