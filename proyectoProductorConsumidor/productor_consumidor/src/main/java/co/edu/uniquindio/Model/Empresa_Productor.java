package co.edu.uniquindio.Model;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Empresa_Productor {

    private static final String QUEUE_NAME = "autos lavando";
    private Tuberia tuberia;

    public Empresa_Productor(Tuberia tuberia) {
        this.tuberia = tuberia;
        producirAutosLavando();
    }

    private void producirAutosLavando() {
        String[] autosLavando = {"TTT111", "JQK779", "LUS358", "GJX152", "HTK465"};

        try{
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            try(Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()){

                channel.queueDeclare(QUEUE_NAME, false, false, false, null);

                for (String auto : autosLavando){
                    tuberia.producir(auto);
                    
                    String mensaje = "Auto producido" + auto;
                    channel.basicPublish("", QUEUE_NAME, null, mensaje.getBytes());
                    
                    System.out.println(" Prdocutor envió mensaje a RabbitMQ: " + mensaje);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}