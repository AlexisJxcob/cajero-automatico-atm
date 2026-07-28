import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicializamos el cajero y el lector de consola
        Cajero cajero = new Cajero();
        Scanner scanner = new Scanner(System.in);

        // Bucle infinito para la pantalla de bienvenida
        while (true) {
            System.out.println("\n=== BIENVENIDO AL CAJERO AUTOMÁTICO ===");
            System.out.print("Ingrese su número de cuenta: ");
            String numero = scanner.nextLine();

            System.out.print("Ingrese su PIN: ");
            String pin = scanner.nextLine();

            // Intentamos autenticar al usuario
            Cuenta cuentaActiva = cajero.buscarYAutenticar(numero, pin);

            if (cuentaActiva != null) {
                System.out.println("\n¡Login exitoso! Bienvenido de nuevo.");

                // Bucle de Sesión Activa
                boolean sesionActiva = true;
                while (sesionActiva) {
                    System.out.println("\n--- MENÚ DE OPERACIONES ---");
                    System.out.println("1. Consultar Saldo");
                    System.out.println("2. Depositar Fondos");
                    System.out.println("3. Retirar Efectivo");
                    System.out.println("4. Ver Historial");
                    System.out.println("5. Cerrar Sesión");
                    System.out.print("Seleccione una opción: ");

                    String opcion = scanner.nextLine();

                    switch (opcion) {
                        case "1":
                            // Opción 1: Consultar Saldo
                            System.out.println("\n[SALDO ACTUAL]");
                            System.out.printf("Su saldo disponible es: $%.2f\n", cuentaActiva.getSaldo());
                            break;

                        case "2":
                            // Opción 2: Depositar Fondos
                            System.out.print("\nIngrese el monto a depositar: $");
                            try {
                                double montoDeposito = Double.parseDouble(scanner.nextLine());
                                if (montoDeposito > 0) {
                                    cuentaActiva.depositar(montoDeposito);
                                    System.out.println("¡Depósito procesado con éxito!");
                                } else {
                                    System.out.println("Error: El monto debe ser mayor a cero.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Ingrese un número válido.");
                            }
                            break;

                        case "3":
                            // Opción 3: Retirar Efectivo
                            System.out.print("\nIngrese el monto a retirar: $");
                            try {
                                double montoRetiro = Double.parseDouble(scanner.nextLine());

                                if (cuentaActiva.retirar(montoRetiro)) {
                                    System.out.println("Emitiendo billetes... Por favor, retire su dinero.");
                                } else {
                                    System.out.println("Error: Fondos insuficientes o monto inválido.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Ingrese un número válido.");
                            }
                            break;

                        case "4":
                            // Opción 4: Ver Historial
                            System.out.println("\n[HISTORIAL DE MOVIMIENTOS]");
                            if (cuentaActiva.getHistorial().isEmpty()) {
                                System.out.println("No se registran movimientos en esta cuenta.");
                            } else {
                                for (String transaccion : cuentaActiva.getHistorial()) {
                                    System.out.println("- " + transaccion);
                                }
                            }
                            break;

                        case "5":
                            // Opción 5: Cerrar Sesión
                            System.out.println("\nCerrando sesión de forma segura... Gracias por usar nuestro servicio.");
                            sesionActiva = false; // Rompe el bucle de la sesión activa
                            break;

                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                            break;
                    }
                }
            } else {
                System.out.println("\n[ERROR] Número de cuenta o PIN incorrectos. Intente nuevamente.");
            }
        }
    }
}
