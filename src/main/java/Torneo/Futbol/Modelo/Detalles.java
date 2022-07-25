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
        return super.informacion(estadio)+ this.pais+this.ciudad;
    }

    @Autowired
    public long informacion(long dinero){
     return super.informacion(dinero);
    }
}
