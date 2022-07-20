package Torneo.Futbol.Modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "grupo")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo" ,unique = true,nullable = false)
    private int id;
    private String descripcion;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupo")
    private Collection<Equipo> equipos;

    public Collection<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(Collection<Equipo> equipos) {
        this.equipos = equipos;
    }
}
