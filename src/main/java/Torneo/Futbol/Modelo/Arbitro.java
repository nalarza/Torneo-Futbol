package Torneo.Futbol.Modelo;

import javax.persistence.*;
import java.util.Collection;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "arbitro")
    private Collection<Partido> partido;

    public Collection<Partido> getPartido() {
        return partido;
    }

    public void setPartido(Collection<Partido> partido) {
        this.partido = partido;
    }


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Pais pais;

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
