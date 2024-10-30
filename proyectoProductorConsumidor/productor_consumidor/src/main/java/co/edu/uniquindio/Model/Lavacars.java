package co.edu.uniquindio.Model;

import java.util.LinkedList;

public class Lavacars {
    private static Lavacars instanciaUnica;
    public String nombre = "LavaCars";
    public LinkedList<Vehiculo> vehiculosLavando;

    public static Lavacars getInstanciaUnica() {
        if(instanciaUnica == null){
            instanciaUnica = new Lavacars();
        }
        return instanciaUnica;
    }

    public Lavacars() {
        this.vehiculosLavando = new LinkedList<>();
    }

    public LinkedList<Vehiculo> getVehiculosLavando() {
        return vehiculosLavando;
    } 
}
