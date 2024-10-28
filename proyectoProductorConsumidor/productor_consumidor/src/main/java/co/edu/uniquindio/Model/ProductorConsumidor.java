package co.edu.uniquindio.Model;
import java.util.Queue;

class ProductorConsumidor{
    private Queue<Integer> lavadero = new LinkedList<>;
    private final int CAPACIDAD = 5;

    public synchronized void ingresarCarro() throws InterruptedException{
        int carro = 0;
        while (true) {
            while (lavadero.size() == CAPACIDAD){
                wait();
            }
            System.out.println("Productor produce: " + carro);
            lavadero.add(carro);
            carro++;
            notify();
            Thread.sleep(2500);
        }
    }

    public synchronized void lavarCarro() throws InterruptedException{
        while (true) {
            while (lavadero.isEmpty()){
                wait();
            }
            int elemento = lavadero.poll();
            System.out.println();
        }
    }
}