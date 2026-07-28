import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private String numeroCuenta;
    private String pin;
    private double saldo;
    private List<String> historial = new ArrayList<>();

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
            registraTrasaccion("Hizo un deposito de: $" + ingresoCantidad + " y su nuevo saldo actual es de: $" + this.saldo);
        }
    }

    // retirar
    public boolean retirar(double retiroCantidad) {
        if (retiroCantidad > 0 && retiroCantidad <= this.saldo) {
            this.saldo -= retiroCantidad;
            registraTrasaccion("Haz retirado la cantidad de: $" + retiroCantidad);
            return true;
        }
        return false;
    }

    // registrar transaccion en el historial
    public void registraTrasaccion(String mensaje) {
        historial.add(mensaje);
    }

    // para que el cajero consulte
    public double getSaldo() {
        return saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public List<String> getHistorial() {
        return historial;
    }

    public boolean verificarPin(String pinIngresado) {
        return this.pin.equals(pinIngresado);
    }
}

