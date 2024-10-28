package co.edu.uniquindio.Model;

public class Main {
    public static void main(String[] args) {
            ProductorConsumidor pc = new ProductorConsumidor();
            Thread consumidor = new Thread (() -> {
                try {
                    pc.lavarCarro();
                }
                catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            });

            consumidor.start();
    }
}