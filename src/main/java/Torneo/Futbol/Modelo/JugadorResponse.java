package Torneo.Futbol.Modelo;

public class JugadorResponse {

    private int id;
    private String nombre;
    private String apellido;
    private int Dorsal;
    private String PaisJuagdor;
    private String equipo;

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

    public int getDorsal() {
        return Dorsal;
    }

    public void setDorsal(int dorsal) {
        Dorsal = dorsal;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getPaisJuagdor() {
        return PaisJuagdor;
    }

    public void setPaisJuagdor(String paisJuagdor) {
        PaisJuagdor = paisJuagdor;
    }
}
