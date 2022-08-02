package Torneo.Futbol.Modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "jugador")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador")
    private int id;
    private String nombre;
    private String apellido;
    private String numero;

    private String paisJugador;

    public String getPaisJugador() {
        return paisJugador;
    }

    public void setPaisJugador(String paisJugador) {
        this.paisJugador = paisJugador;
    }

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_equipo")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Equipo equipo;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_pais")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Pais pais;

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Jugador() {
    }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}


