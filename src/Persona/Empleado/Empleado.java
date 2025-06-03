package Persona.Empleado;

import Persona.Persona;
import Persona.Cliente.Cliente;
import Producto.Cuenta;

public abstract class Empleado extends Persona {
    private String usuario;
    private String clave;

    public Empleado(String nombre, String cedula, String direccion, String telefono, String usuario, String clave) {
        super(nombre, cedula, direccion, telefono);
        this.usuario = usuario;
        this.clave = clave;
    }

    public boolean autenticarEmpleado(String usuario, String clave) {
        return this.usuario.equals(usuario) && this.clave.equals(clave);
    }

    public void crearCuentaParaCliente(Cliente cliente, String tipo) {
        System.out.println("Empleado " + nombre + " creando cuenta de tipo " + tipo + " para cliente " + cliente.getNombre());
    }

    public void modificarDatosCliente(Cliente cliente) {
        System.out.println("Empleado " + nombre + " modificando datos del cliente " + cliente.getNombre());
    }

    public void registrarPrestamo(Cliente cliente, double monto) {
        System.out.println("Empleado " + nombre + " registrando préstamo de $" + monto + " para cliente " + cliente.getNombre());
    }

    public void cerrarCuenta(Cliente cliente, Cuenta cuenta) {
        System.out.println("Empleado " + nombre + " cerrando cuenta para cliente " + cliente.getNombre());
    }

    public String getUsuario() {
        return usuario;
    }
}