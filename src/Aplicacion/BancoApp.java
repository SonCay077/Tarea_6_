package Aplicacion;

import Persona.Cliente.Cliente;
import Persona.Empleado.Empleado;
import Persona.Empleado.Cajero.Cajero;
import Persona.Empleado.BalconServivios.BalconServicios;
import Persona.Empleado.JefeAgencia.JefeAgencia;
import Producto.TarjetaCredito;
import Producto.Cuenta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BancoApp {

    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Empleado> empleados = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        clientes.add(new Cliente("Juan Perez", "123", "Av. Principal 123", "0987654321"));
        clientes.add(new Cliente("Maria Lopez", "456", "Calle Secundaria 456", "0991234567"));

        empleados.add(new Cajero("Carlos Gomez", "789", "Calle Falsa 123", "0981112233", "cajero1", "pass1"));
        empleados.add(new BalconServicios("Ana Diaz", "101", "Av. Siempre Viva 789", "0994445566", "balcon1", "pass2"));
        empleados.add(new JefeAgencia("Roberto Salas", "202", "El Centro 101", "0967778899", "jefe1", "pass3"));

        int opcion;
        do {
            System.out.println("\n--- SISTEMA BANCARIO ---\n1. Registrar cliente\n2. Ingresar como cliente\n3. Ingresar como empleado\n4. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt(); scanner.nextLine();

            switch (opcion) {
                case 1: registrarNuevoCliente(); break;
                case 2: ingresarComoCliente(); break;
                case 3: ingresarComoEmpleado(); break;
                case 4: System.out.println("Saliendo."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
        scanner.close();
    }

    private static void registrarNuevoCliente() {
        System.out.print("Nombre: "); String nombre = scanner.nextLine();
        System.out.print("Cédula: "); String cedula = scanner.nextLine();
        System.out.print("Dirección: "); String direccion = scanner.nextLine();
        System.out.print("Teléfono: "); String telefono = scanner.nextLine();
        clientes.add(new Cliente(nombre, cedula, direccion, telefono));
        System.out.println("Cliente registrado.");
    }

    private static void ingresarComoCliente() {
        System.out.print("Cédula: "); String cedula = scanner.nextLine();
        Cliente c = buscarClientePorCedula(cedula);
        if (c != null) { c.ingresarAlSistema(); menuCliente(c); }
        else { System.out.println("Cliente no encontrado."); }
    }

    private static void menuCliente(Cliente cliente) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ CLIENTE (" + cliente.getNombre() + ") ---\n1. Registrar cuenta\n2. Solicitar préstamo\n3. Agregar tarjeta\n4. Ver resumen\n0. Volver");
            System.out.print("Opción: ");
            opcion = scanner.nextInt(); scanner.nextLine();

            switch (opcion) {
                case 1: System.out.print("Tipo de cuenta: "); cliente.registrarCuenta(scanner.nextLine()); break;
                case 2: System.out.print("Monto préstamo: "); cliente.solicitarPrestamo(scanner.nextDouble()); scanner.nextLine(); break;
                case 3:
                    System.out.print("Número tarjeta: "); String numTarjeta = scanner.nextLine();
                    System.out.print("Tipo tarjeta: "); String tipoTarjeta = scanner.nextLine();
                    System.out.print("Límite crédito: "); double limiteCredito = scanner.nextDouble(); scanner.nextLine();
                    cliente.agregarTarjetaCredito(new TarjetaCredito(numTarjeta, tipoTarjeta, limiteCredito)); break;
                case 4: cliente.verResumenFinanciero(); break;
                case 0: System.out.println("Volviendo."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void ingresarComoEmpleado() {
        System.out.print("Usuario: "); String usuario = scanner.nextLine();
        System.out.print("Clave: "); String clave = scanner.nextLine();

        Empleado e = null;
        for (Empleado emp : empleados) {
            if (emp.autenticarEmpleado(usuario, clave)) { e = emp; break; }
        }

        if (e != null) {
            e.mostrarRol();
            if (usuario.equals("cajero1")) menuCajero((Cajero) e);
            else if (usuario.equals("balcon1")) menuBalconServicios((BalconServicios) e);
            else if (usuario.equals("jefe1")) menuJefeAgencia((JefeAgencia) e);
            else System.out.println("Rol no reconocido.");
        } else { System.out.println("Credenciales incorrectas."); }
    }

    private static void menuCajero(Cajero cajero) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ CAJERO (" + cajero.getNombre() + ") ---\n1. Procesar retiro\n2. Procesar depósito\n3. Consultar saldo\n0. Volver");
            System.out.print("Opción: ");
            opcion = scanner.nextInt(); scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Cédula cliente: "); Cliente cr = buscarClientePorCedula(scanner.nextLine());
                    if (cr != null) { System.out.print("Monto: "); cajero.procesarRetiro(cr, scanner.nextDouble()); scanner.nextLine(); }
                    else System.out.println("Cliente no existe."); break;
                case 2:
                    System.out.print("Cédula cliente: "); Cliente cd = buscarClientePorCedula(scanner.nextLine());
                    if (cd != null) { System.out.print("Monto: "); cajero.procesarDeposito(cd, scanner.nextDouble()); scanner.nextLine(); }
                    else System.out.println("Cliente no existe."); break;
                case 3:
                    System.out.print("Cédula cliente: "); Cliente cc = buscarClientePorCedula(scanner.nextLine());
                    if (cc != null) cajero.consultarSaldo(cc); else System.out.println("Cliente no existe."); break;
                case 0: System.out.println("Volviendo."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void menuBalconServicios(BalconServicios balcon) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ BALCÓN SERVICIOS (" + balcon.getNombre() + ") ---\n1. Registrar nuevo cliente\n2. Actualizar datos cliente\n0. Volver");
            System.out.print("Opción: ");
            opcion = scanner.nextInt(); scanner.nextLine();

            switch (opcion) {
                case 1: clientes.add(balcon.registrarNuevoCliente(scanner)); System.out.println("Cliente registrado."); break;
                case 2:
                    System.out.print("Cédula cliente a actualizar: "); Cliente ca = buscarClientePorCedula(scanner.nextLine());
                    if (ca != null) balcon.actualizarDatosCliente(ca, scanner); else System.out.println("Cliente no existe."); break;
                case 0: System.out.println("Volviendo."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void menuJefeAgencia(JefeAgencia jefe) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ JEFE AGENCIA (" + jefe.getNombre() + ") ---\n1. Aprobar préstamo\n2. Generar reporte\n3. Evaluar empleado\n0. Volver");
            System.out.print("Opción: ");
            opcion = scanner.nextInt(); scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Cédula cliente: "); Cliente cp = buscarClientePorCedula(scanner.nextLine());
                    if (cp != null) { System.out.print("Monto: "); jefe.aprobarPrestamo(cp, scanner.nextDouble()); scanner.nextLine(); }
                    else System.out.println("Cliente no existe."); break;
                case 2: jefe.generarReporteOperaciones(); break;
                case 3:
                    System.out.print("Cédula empleado: "); Empleado ee = buscarEmpleadoPorCedula(scanner.nextLine());
                    if (ee != null) jefe.evaluarEmpleado(ee); else System.out.println("Empleado no existe."); break;
                case 0: System.out.println("Volviendo."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static Cliente buscarClientePorCedula(String cedula) {
        for (Cliente c : clientes) if (c.getCedula().equals(cedula)) return c;
        return null;
    }

    private static Empleado buscarEmpleadoPorCedula(String cedula) {
        for (Empleado e : empleados) if (e.getCedula().equals(cedula)) return e;
        return null;
    }
}