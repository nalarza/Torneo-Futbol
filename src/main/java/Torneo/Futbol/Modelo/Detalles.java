package Torneo.Futbol.Modelo;

import org.springframework.beans.factory.annotation.Autowired;

public class Detalles extends Equipo{
    private String moneda;
    private String pais;
    private String ciudad;

    public Detalles(){
    }
    public Detalles(String nombreDelEquipo,String entrenador,String nacionalidad,String moneda,
                    String pais,String ciudad){
        super(nombreDelEquipo,entrenador,nacionalidad);
        this.moneda=moneda;
        this.pais=pais;
        this.ciudad=ciudad;
    }
    @Autowired
    public String informacion(String estadio){
        return super.informacion(estadio);
    }

    @Autowired
    public long informacion(long dinero){
     return super.informacion(dinero);
    }



    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
