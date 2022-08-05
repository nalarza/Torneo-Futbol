package Torneo.Futbol.Modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "partido")
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_partido" ,unique = true,nullable = false)
    private int Id;

    @OneToMany(mappedBy = "partido", cascade = CascadeType.ALL)
    private Set<Evento> eventos = new HashSet<>();



    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_arbitro")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Arbitro arbitro;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_estadio")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Estadio estadio;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_equipoUno")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Equipo equipoUno;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_equipoDos")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Equipo equipoDos;

    public Partido() {
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Set<Evento> getEventos() {
        return eventos;
    }

    public Equipo getEquipoUno() {
        return equipoUno;
    }

    public void setEquipoUno(Equipo equipoUno) {
        this.equipoUno = equipoUno;
    }

    public Equipo getEquipoDos() {
        return equipoDos;
    }

    public void setEquipoDos(Equipo equipoDos) {
        this.equipoDos = equipoDos;
    }

    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
        for (Evento evento:eventos){
            evento.setPartido(this);
        }
    }
}
