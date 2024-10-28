package co.edu.uniquindio.Model;

import java.util.Queue;
import java.util.LinkedList;

class ProductorConsumidor{
    private Queue<Vehiculo> vehiculosLavando = new LinkedList<>();
    private Queue<Vehiculo> vehiculosLavados = new LinkedList<>();
    private final int CAPACIDAD = 5;
    
    public synchronized void ingresarCarro(Vehiculo vehiculo) throws InterruptedException{
            if(vehiculosLavando.size() == CAPACIDAD){
                System.out.println("No se pueden ingresar más vehículos.");
            }
            System.out.println("Ingresando carro: " + vehiculo.getReferenciaVehiculo());
            vehiculosLavando.add(vehiculo);
            notify();
            }

    public synchronized void lavarCarro() throws InterruptedException{
        while (true) {
            while (vehiculosLavando.isEmpty()){
                wait();
            }
            Vehiculo vehiculoLavado = vehiculosLavando.poll();
            System.out.println("Vehiculo listo: "+ vehiculoLavado + " ");
            vehiculosLavados.add(vehiculoLavado);
            notify();
            Thread.sleep(5000);
        }
    }
}
