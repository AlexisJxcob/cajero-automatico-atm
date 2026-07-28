import java.util.ArrayList;
import java.util.List;

public class Cajero {
    private List<Cuenta> cuentas = new ArrayList<>();

    public Cajero(List<Cuenta> cuentas) {
        cuentas.add(new Cuenta("12345", 50000.0, "1111"));
        cuentas.add(new Cuenta("67890", 120000.0, "2222"));
    }

    public Cuenta buscarYVerificar(String numCuenta, String pin) {
        for (Cuenta c : cuentas) {
            if (c.getNumeroCuenta().equals(numCuenta)) {
                if (c.verificarPin(pin)) {
                    return c; // login exitoso
                }
            }
        }
        return null; // si cuenta no coincide se termina
    }
}
