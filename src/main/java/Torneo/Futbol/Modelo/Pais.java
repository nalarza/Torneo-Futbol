package Torneo.Futbol.Modelo;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.Collection;

@Entity
@Table(name = "pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais" ,unique = true,nullable = false)
    private int id;
    private String nombre;

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


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pais")
    private Collection<Equipo> equipos;

    public Collection<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(Collection<Equipo> equipos) {
        this.equipos = equipos;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pais")
    private Collection<Arbitro> arbitros;

    public Collection<Arbitro> getArbitros() {
        return arbitros;
    }

    public void setArbitros(Collection<Arbitro> arbitros) {
        this.arbitros = arbitros;
    }
}
