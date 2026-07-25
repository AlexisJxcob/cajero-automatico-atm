import java.util.ArrayList;

public class Cuenta {
    private String numeroCuenta;
    private String pin;
    private double saldo;
    private ArrayList<String> historial = new ArrayList<>();

    public Cuenta(String numeroCuenta, double saldo, String pin) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.pin = pin;
    }

    // metodos
    // para depositar dinero en efectivo
    public void depositar(double ingresoCantidad) {
        if (ingresoCantidad > 0) {
         this.saldo += ingresoCantidad;
         registraRetiro("Hizo un deposito de: $" + ingresoCantidad + " y su nuevo saldo actual es de: $" + this.saldo);
        }
    }

    // retirar
    public double retirar(double retiroCantidad) {
        return retiroCantidad;
    }

    // registrar transaccion en el historial
    public void registraRetiro(String mensaje) {
    historial.add(mensaje);
    }
}
