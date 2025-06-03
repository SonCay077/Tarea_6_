package Persona.Cliente;

import Persona.Persona;
import Producto.TarjetaCredito;
import Producto.Cuenta;

public class Cliente extends Persona {

    public Cliente(String nombre, String cedula, String direccion, String telefono) {
        super(nombre, cedula, direccion, telefono);
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Cliente bancario");
    }

    public boolean ingresarAlSistema() {
        System.out.println("Cliente " + nombre + " ha ingresado al sistema.");
        return true;
    }

    public void registrarCuenta(String tipo) {
        System.out.println("Cliente " + nombre + " ha registrado una cuenta de tipo: " + tipo);
    }

    public void solicitarPrestamo(double monto) {
        System.out.println("Cliente " + nombre + " ha solicitado un préstamo por: $" + monto);
    }

    public void agregarTarjetaCredito(TarjetaCredito tarjeta) {
        System.out.println("Cliente " + nombre + " ha agregado una tarjeta de crédito.");
    }

    public void verResumenFinanciero() {
        System.out.println("Mostrando resumen financiero para el cliente " + nombre);
    }
}