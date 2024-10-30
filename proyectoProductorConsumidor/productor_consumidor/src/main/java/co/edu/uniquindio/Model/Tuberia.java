package co.edu.uniquindio.Model;

import java.util.LinkedList;
import java.util.Queue;

public class Tuberia {
    private Queue<String> buffer;
    private int capacidad;

    public Tuberia(int capacidad) {
        this.capacidad = capacidad;
        this.buffer = new LinkedList<String>();
    }

    public synchronized void producir(String placa) throws InterruptedException {
        while(buffer.size() == capacidad){
            wait();
        }
        buffer.add(placa);
        notifyAll();
    }

    public synchronized String consumir(String placaSolicitada){
        if(buffer.contains(placaSolicitada)){
            buffer.remove(placaSolicitada);
            return placaSolicitada;
        }
        return null;
    }

    public synchronized boolean hayCarro(String placaSolicitada){
        return buffer.contains(placaSolicitada);
    }
}
