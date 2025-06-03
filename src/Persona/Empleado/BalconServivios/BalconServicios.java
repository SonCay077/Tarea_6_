package Persona.Empleado.BalconServivios;

import Persona.Empleado.Empleado;
import Persona.Cliente.Cliente;
import java.util.Scanner; // Importar Scanner para entrada de datos

public class BalconServicios extends Empleado {
    public BalconServicios(String nombre, String cedula, String direccion, String telefono, String usuario, String clave) {
        super(nombre, cedula, direccion, telefono, usuario, clave);
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Balcón de Servicios");
    }

    public Cliente registrarNuevoCliente(Scanner scanner) {
        System.out.println("--- Registro de Nuevo Cliente ---");
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese cédula: ");
        String cedula = scanner.nextLine();
        System.out.print("Ingrese dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese teléfono: ");
        String telefono = scanner.nextLine();
        System.out.println("Balcón de Servicios " + getNombre() + " registrando nuevo cliente: " + nombre);
        return new Cliente(nombre, cedula, direccion, telefono);
    }

    public void actualizarDatosCliente(Cliente cliente, Scanner scanner) {
        System.out.println("--- Actualizar Datos de Cliente " + cliente.getNombre() + " ---");
        System.out.print("Nueva dirección (actual: " + cliente.getDireccion() + "): ");
        String nuevaDireccion = scanner.nextLine();
        System.out.print("Nuevo teléfono (actual: " + cliente.getTelefono() + "): ");
        String nuevoTelefono = scanner.nextLine();
        cliente.actualizarDatos(nuevaDireccion, nuevoTelefono);
        System.out.println("Datos del cliente " + cliente.getNombre() + " actualizados por " + getNombre());
    }
}