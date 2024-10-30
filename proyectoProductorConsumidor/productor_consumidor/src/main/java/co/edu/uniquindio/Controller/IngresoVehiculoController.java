package co.edu.uniquindio.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeoutException;

import co.edu.uniquindio.Model.Cliente_Consumidor;
import co.edu.uniquindio.Model.Lavacars;
import co.edu.uniquindio.Model.Tuberia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class IngresoVehiculoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_ingresar1;

    @FXML
    private TextArea txt_autos;

    @FXML
    private TextField txt_placa_retirar;

    Lavacars lavadero = Lavacars.getInstanciaUnica();

    @FXML
    void btn_ingresar(ActionEvent event) throws IOException, TimeoutException {
        String placa = txt_placa_retirar.getText();
        Tuberia tuberia = new Tuberia(5);
        Cliente_Consumidor consumidor = new Cliente_Consumidor(tuberia, this, placa);
        consumidor.run();
    }

    public void mostrarMensaje(String mensaje){
        txt_autos.setText(mensaje);
    }

    @FXML
    void initialize() {
        assert btn_ingresar1 != null : "fx:id=\"btn_ingresar1\" was not injected: check your FXML file 'ingresoVehiculo.fxml'.";
        assert txt_autos != null : "fx:id=\"txt_autos\" was not injected: check your FXML file 'ingresoVehiculo.fxml'.";
        assert txt_placa_retirar != null : "fx:id=\"txt_placa_retirar\" was not injected: check your FXML file 'ingresoVehiculo.fxml'.";

    }

}
