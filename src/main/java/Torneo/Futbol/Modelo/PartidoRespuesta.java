package Torneo.Futbol.Modelo;

public class PartidoRespuesta {

    private int id;
    private String nombreDelEstadio;
    private String EquipoLocal;
    private String EquipoVisitante;
    private String nombreDelArbitro;
    private String PaisDelEstadio;
    private  String paisDelArbitro;
    private String Ciudad;


    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaisDelArbitro() {
        return paisDelArbitro;
    }

    public void setPaisDelArbitro(String paisDelArbitro) {
        this.paisDelArbitro = paisDelArbitro;
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
