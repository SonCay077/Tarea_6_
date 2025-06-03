package Persona.Empleado.JefeAgencia;

import Persona.Empleado.Empleado;
import Persona.Cliente.Cliente;

public class JefeAgencia extends Empleado {
    public JefeAgencia(String nombre, String cedula, String direccion, String telefono, String usuario, String clave) {
        super(nombre, cedula, direccion, telefono, usuario, clave);
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Jefe de Agencia (Gerente)");
    }

    public boolean aprobarPrestamo(Cliente cliente, double monto) {
        System.out.println("Jefe de Agencia " + getNombre() + " evaluando aprobación de préstamo de $" + monto + " para cliente " + cliente.getNombre());
        System.out.println("Préstamo de $" + monto + " para " + cliente.getNombre() + " aprobado.");
        return true;
    }

    public void generarReporteOperaciones() {
        System.out.println("Jefe de Agencia " + getNombre() + " generando reporte de operaciones.");
    }

    public void evaluarEmpleado(Empleado empleado) {
        System.out.println("Jefe de Agencia " + getNombre() + " evaluando al empleado " + empleado.getNombre());
    }
}