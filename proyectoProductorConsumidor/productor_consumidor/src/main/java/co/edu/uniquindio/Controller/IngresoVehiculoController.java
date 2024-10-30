package co.edu.uniquindio.Controller;

import java.net.URL;
import java.util.ResourceBundle;

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

    Lavacars lavadero = Lavadero.getInstanciaUnica();

    @FXML
    void btn_ingresar(ActionEvent event) {
        String placa = txt_placa_retirar.getText();
        Cliente_Consumidor consumidor = new Cliente_Consumidor();
    }

    public void mostrarMensaje(String mensaje){
        txt_autos.setText(mensaje);
    }

    @FXML
    void initialize() {
        assert btn_ingresar1 != null : "fx:id=\"btn_ingresar1\" was not injected: check your FXML file 'ingresoVehiculo.fxml'.";
        assert txt_autos != null : "fx:id=\"txt_autos\" was not injected: check your FXML file 'ingresoVehiculo.fxml'.";
        assert txt_autosListos != null : "fx:id=\"txt_autosListos\" was not injected: check your FXML file 'ingresoVehiculo.fxml'.";
        assert txt_placa_retirar != null : "fx:id=\"txt_placa_retirar\" was not injected: check your FXML file 'ingresoVehiculo.fxml'.";

    }

}
