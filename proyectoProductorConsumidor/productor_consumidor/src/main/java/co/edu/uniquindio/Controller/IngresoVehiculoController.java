package co.edu.uniquindio.Controller;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.Model.Lavacars;
import co.edu.uniquindio.Model.Vehiculo;
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
    private Button btn_ingresar;

    @FXML
    private Button btn_ingresar1;

    @FXML
    private TextArea txt_autosLavando;

    @FXML
    private TextArea txt_autosListos;

    @FXML
    private TextField txt_marca;

    @FXML
    private TextField txt_placa;

    @FXML
    private TextField txt_placa_retirar;

    @FXML
    private TextField txt_propietario;

    Lavacars lavacars = Lavacars.getInstanciaUnica();

    @FXML
    void btn_ingresar(ActionEvent event) {
        String nombrePropietario = txt_propietario.getText();
        String placa = txt_placa.getText();
        String marca = txt_marca.getText();

        Vehiculo vehiculo = new Vehiculo(nombrePropietario, placa, marca);
        System.out.println("El " + marca + " de placa " + placa + " ingresó a lavado");
    }

    @FXML
    void initialize() {
        assert btn_ingresar != null : "fx:id=\"btn_ingresar\" was not injected: check your FXML file 'ingresoVehiculo.fxml'.";
        assert btn_ingresar1 != null : "fx:id=\"btn_ingresar1\" was not injected: check your FXML file 'ingresoVehiculo.fxml'.";
        assert txt_autosLavando != null : "fx:id=\"txt_autosLavando\" was not injected: check your FXML file 'ingresoVehiculo.fxml'.";
        assert txt_autosListos != null : "fx:id=\"txt_autosListos\" was not injected: check your FXML file 'ingresoVehiculo.fxml'.";
        assert txt_marca != null : "fx:id=\"txt_marca\" was not injected: check your FXML file 'ingresoVehiculo.fxml'.";
        assert txt_placa != null : "fx:id=\"txt_placa\" was not injected: check your FXML file 'ingresoVehiculo.fxml'.";
        assert txt_placa_retirar != null : "fx:id=\"txt_placa_retirar\" was not injected: check your FXML file 'ingresoVehiculo.fxml'.";
        assert txt_propietario != null : "fx:id=\"txt_propietario\" was not injected: check your FXML file 'ingresoVehiculo.fxml'.";

    }

}
