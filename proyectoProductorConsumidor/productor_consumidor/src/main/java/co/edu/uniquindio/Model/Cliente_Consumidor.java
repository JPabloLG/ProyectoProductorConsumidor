package co.edu.uniquindio.Model;

import co.edu.uniquindio.Controller.IngresoVehiculoController;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import java.nio.charset.StandardCharsets;
import com.rabbitmq.client.AMQP;



import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Cliente_Consumidor implements Runnable {

    private static final String QUEUE_NAME = "autos lavando";
    private Tuberia tuberia;
    private IngresoVehiculoController controller;
    private String placaSolicitada;
    private Connection connection;
    private Channel channel;
    private volatile boolean running;

    public Cliente_Consumidor(Tuberia tuberia, IngresoVehiculoController controller, String placaSolicitada) throws IOException, TimeoutException{
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
        System.out.println("Esperando mensajes en RabbitMQ...");

        new Thread(() -> {
            try{
                String autoConsumido = tuberia.consumir(placaSolicitada);
                if(autoConsumido != null){
                    System.out.println("Auto consumido: " + autoConsumido);
                    controller.mostrarMensaje("Auto consumido: " + autoConsumido);

                    String mensaje = "Auto consumido: " + autoConsumido;
                    channel.basicPublish("", QUEUE_NAME, null, mensaje.getBytes());
                    System.out.println("Mensaje enviado a RabbitMQ: " + mensaje);
                } else {
                    System.out.println("Auto requerido no encontrado");
                    controller.mostrarMensaje("El auto solicitado no se encuentra en lavado");
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }).start();


        try {
            channel.basicConsume(QUEUE_NAME, false, new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String mensaje = new String(body, StandardCharsets.UTF_8);
                    System.out.println("Mensaje recibido: " + mensaje);

                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
