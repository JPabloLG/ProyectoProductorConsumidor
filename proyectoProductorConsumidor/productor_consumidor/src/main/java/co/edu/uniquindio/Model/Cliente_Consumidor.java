package co.edu.uniquindio.Model;

import co.edu.uniquindio.Controller.IngresoVehiculoController;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;

public class Cliente_Consumidor implements Runnable {

    private static final String QUEUE_NAME = "autos lavando";
    private Tuberia tuberia;
    private IngresoVehiculoController controller;
    private String placaSolicitada;
    private Connection connection;
    private Channel channel;
    private volatile boolean running;

    public Cliente_Consumidor(Tuberia tuberia, IngresoVehiculoController controller, String placaSolicitada) throws IOException{
        this.tuberia = tuberia;
        this.controller = controller;
        this.placaSolicitada = placaSolicitada;

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        this.connection = factory.newConnection();
        this.channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    }

    @Override
    public void run() {
        
        
    }
}
