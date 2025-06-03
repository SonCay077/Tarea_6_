package Producto;

public class Cuenta {
    private String numeroCuenta;
    private String tipoCuenta;
    private double saldo;

    public Cuenta(String numeroCuenta, String tipoCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
    }

    // Getters y Setters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Depósito de $" + monto + " realizado. Nuevo saldo: $" + this.saldo);
        } else {
            System.out.println("El monto del depósito debe ser positivo.");
        }
    }

    public void retirar(double monto) {
        if (monto > 0 && this.saldo >= monto) {
            this.saldo -= monto;
            System.out.println("Retiro de $" + monto + " realizado. Nuevo saldo: $" + this.saldo);
        } else if (monto <= 0) {
            System.out.println("El monto del retiro debe ser positivo.");
        } else {
            System.out.println("Saldo insuficiente para realizar el retiro.");
        }
    }
}