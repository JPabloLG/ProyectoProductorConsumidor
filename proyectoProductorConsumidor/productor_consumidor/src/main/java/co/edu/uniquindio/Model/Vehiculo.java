package co.edu.uniquindio.Model;

public class Vehiculo {
    private String propietarioNombre;
    public String placa;
    public String referenciaVehiculo;
    
    public Vehiculo(String propietarioNombre, String placa, String referenciaVehiculo) {
        this.propietarioNombre = propietarioNombre;
        this.placa = placa;
        this.referenciaVehiculo = referenciaVehiculo;
    }

    public String getPropietario() {
        return propietarioNombre;
    }

    public void setPropietario(Propietario propietario) {
        this.propietarioNombre = propietarioNombre;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getReferenciaVehiculo() {
        return referenciaVehiculo;
    }

    public void setReferenciaVehiculo(String referenciaVehiculo) {
        this.referenciaVehiculo = referenciaVehiculo;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
