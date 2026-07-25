import java.util.ArrayList;

public class Cuenta {
    private String numeroCuenta;
    private String pin;
    private double saldo;
    private ArrayList historial = new ArrayList();

    // metodos
    // para depositar dinero en efectivo
    public double depositar (double ingresoCantidad) {
        return ingresoCantidad;
    }

    // retirar
    public double retirar (double retiroCantidad) {
        return retiroCantidad;
    }

    // registrar transaccion en el historial
    public void registraRetiro (String mensaje){

    }
}
