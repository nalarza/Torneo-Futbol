package Torneo.Futbol.Modelo;

public class PartidoRespuesta {

    private int id;
    private String nombreDelEstadio;
    private String EquipoLocal;
    private String EquipoVisitante;
    private String nombreDelArbitro;
    private String PaisDelEstadio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDelEstadio() {
        return nombreDelEstadio;
    }

    public void setNombreDelEstadio(String nombreDelEstadio) {
        this.nombreDelEstadio = nombreDelEstadio;
    }

    public String getEquipoLocal() {
        return EquipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        EquipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return EquipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        EquipoVisitante = equipoVisitante;
    }

    public String getNombreDelArbitro() {
        return nombreDelArbitro;
    }

    public void setNombreDelArbitro(String nombreDelArbitro) {
        this.nombreDelArbitro = nombreDelArbitro;
    }

    public String getPaisDelEstadio() {
        return PaisDelEstadio;
    }

    public void setPaisDelEstadio(String paisDelEstadio) {
        PaisDelEstadio = paisDelEstadio;
    }
}
