package co.edu.uniquindio.Model;

import java.util.LinkedList;

public class Lavacars {
    private static Lavacars instanciaUnica;
    public String nombre = "LavaCars";
    public Tuberia tuberia;
    public Cliente_Consumidor consumidor;

    public static Lavacars getInstanciaUnica() {
        if(instanciaUnica == null){
            instanciaUnica = new Lavacars();
        }
        return instanciaUnica;
    }

}
