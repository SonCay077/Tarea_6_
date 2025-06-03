package Producto;

public class TarjetaCredito {
    private String numeroTarjeta;
    private String tipo;
    private double limiteCredito;

    public TarjetaCredito(String numeroTarjeta, String tipo, double limiteCredito) {
        this.numeroTarjeta = numeroTarjeta;
        this.tipo = tipo;
        this.limiteCredito = limiteCredito;
    }

    // Getters
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getTipo() {
        return tipo;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }
}