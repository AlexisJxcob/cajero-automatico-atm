# 🏦 Simulador de Cajero Automático (ATM) en Java

Este proyecto consiste en un simulador de Cajero Automático que corre completamente en la consola de comandos. Su objetivo principal es aplicar y consolidar los conceptos clave de la **Programación Orientada a Objetos (POO)** y el control de flujos lógicos en Java puro, simulando un entorno financiero interactivo.

## 🎯 El Problema a Resolver

En las aplicaciones de consola iniciales, el código suele ser lineal y los datos se pierden o se mezclan fácilmente. El reto de este proyecto es modelar un sistema donde coexistan múltiples usuarios, cada uno con su información privada (número de cuenta, PIN de seguridad y dinero disponible), y garantizar que las operaciones financieras se ejecuten bajo reglas estrictas de negocio.

El sistema debe resolver los siguientes problemas del mundo real:
1. **Seguridad y Autenticación:** Nadie puede operar el cajero si no ingresa un número de cuenta existente y su clave PIN correcta.
2. **Integridad de Datos:** No se puede retirar más dinero del que realmente existe en la cuenta (evitar saldos negativos).
3. **Encapsulamiento:** El saldo de un usuario no puede ser modificado directamente desde fuera de su cuenta; debe hacerse a través de métodos seguros de depósito y retiro.
4. **Historial de Operaciones:** El sistema debe recordar los movimientos realizados por el usuario durante su sesión actual.

---

## 🛠️ Conceptos Clave que Práctico Aquí

* **Encapsulamiento Estricto:** Uso de modificadores de acceso `private` para proteger el saldo y las claves, exponiendo el acceso seguro mediante *Getters* y *Setters*.
* **Relaciones entre Clases:** Interacción entre una clase que actúa como base de datos de usuarios (`Cajero`) y las entidades individuales (`Cuenta`).
* **Colecciones en Memoria (`ArrayList`):** Almacenamiento dinámico de la lista de cuentas disponibles y del historial de transacciones de cada cliente.
* **Control de Excepciones Básicas:** Validaciones mediante condicionales e instrucciones de escape para evitar fallos catastróficos en el flujo de ejecución.

---

## 📝 Lista de Tareas (TODO)

Puedes seguir este orden de desarrollo para construir el proyecto desde cero:

### 🧩 Fase 1: El Modelo del Cliente (`Cuenta.java`)
  * [ ] **Definir propiedades privadas:** Crear atributos para `numeroCuenta` (String), `pin` (String), `saldo` (double) y un `ArrayList<String>` para el historial.
  * [ ] **Configurar el Constructor:** Permitir la creación de cuentas pasando el número, el PIN y un saldo inicial.
  * [ ] **Métodos de negocio internos:**
  * [ ] Crear el método `bool verificarPin(String pinIngresado)`.
  * [ ] Crear el método `void depositar(double cantidad)`.
  * [ ] Crear el método `boolean retirar(double cantidad)` (debe retornar `true` si la operación fue exitosa o `false` si no había fondos suficientes).
  * [ ] Crear el método `void registrarMovimiento(String descripcion)`.

### 🧠 Fase 2: El Cerebro del Cajero (`Cajero.java`)
  * [ ] **Estructura del Banco:** Crear una clase con una lista `ArrayList<Cuenta>` para pre-cargar clientes de prueba en un método inicializador.
  * [ ] **Lógica de login:** Programar el método `Cuenta buscarYAutenticar(String numero, String pin)` que recorra la lista de cuentas, valide las credenciales y devuelva el objeto `Cuenta` activo.

### 📱 Fase 3: Flujo Interactivo y Menú de Usuario (`Main.java`)
  * [ ] **Pantalla de Bienvenida:** Solicitar las credenciales del usuario usando `Scanner`.
  * [ ] **Bucle de Sesión Activa:** Si el login es exitoso, abrir un ciclo `while` interactivo que ofrezca las opciones financieras:
  * [ ] **1. Consultar Saldo:** Mostrar de forma limpia el dinero disponible de la cuenta logueada.
  * [ ] **2. Depositar Fondos:** Solicitar monto, procesar y guardar la confirmación en el historial.
  * [ ] **3. Retirar Efectivo:** Solicitar monto, validar saldo y emitir billetes (o mostrar mensaje de fondos insuficientes).
  * [ ] **4. Ver Historial:** Recorrer e imprimir la lista de movimientos registrados en la sesión.
  * [ ] **5. Cerrar Sesión:** Romper el bucle actual y regresar a la pantalla de login para permitir que otro usuario ingrese.
