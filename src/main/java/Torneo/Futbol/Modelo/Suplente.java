package Torneo.Futbol.Modelo;

public class Suplente {
    private String nombre;
    private int edad;
    private double sueldo;

    public Suplente(String nombre, int edad, double sueldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }
    public String mostrarDatos(){
        return "Nomber: "+nombre+"\nedad: "+edad+"\nsueldo: $"+sueldo+"\n";
    }
    //creacion de clase suplente
}
