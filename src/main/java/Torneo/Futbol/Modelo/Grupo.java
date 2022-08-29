package Torneo.Futbol.Modelo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "grupo")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo" ,unique = true,nullable = false)
    private int id;
    private String descripcion;

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
    private Set<Equipo> equipos = new HashSet<>();

    public Grupo() {
    }

    public Grupo(int id, String descripcion, Set<Equipo> equipos) {
        this.id = id;
        this.descripcion = descripcion;
        this.equipos = equipos;
    }

    public Grupo(String descripcion) {
        this.descripcion = descripcion;
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

    public Set<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(Set<Equipo> equipos) {
        this.equipos = equipos;
        for (Equipo equipo:equipos){
            equipo.setGrupo(this);
        }
    }
}
