package Persona.Empleado.Cajero;

import Persona.Empleado.Empleado;
import Persona.Cliente.Cliente;
import Producto.Cuenta;

public class Cajero extends Empleado {
    public Cajero(String nombre, String cedula, String direccion, String telefono, String usuario, String clave) {
        super(nombre, cedula, direccion, telefono, usuario, clave);
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Cajero");
    }

    public void procesarRetiro(Cliente cliente, double monto) {
        System.out.println("Cajero " + getNombre() + " procesando retiro de $" + monto + " para cliente " + cliente.getNombre());
    }

    public void consultarSaldo(Cliente cliente) {
        System.out.println("Cajero " + getNombre() + " consultando saldo para cliente " + cliente.getNombre());
    }

    public void procesarDeposito(Cliente cliente, double monto) {
        System.out.println("Cajero " + getNombre() + " procesando depósito de $" + monto + " para cliente " + cliente.getNombre());
    }
}