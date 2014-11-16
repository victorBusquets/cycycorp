package com.fpmislata.banco.dominio;

public class MovimientoBancario {

    int idMovimientoBancario;

    int CuentaOrigen;

    int CuentaDestino;

    double cantidad;

    String motivo;

    public MovimientoBancario(int idMovimientoBancario, int CuentaOrigen, int CuentaDestino, double cantidad, String motivo) {
        this.idMovimientoBancario = idMovimientoBancario;
        this.CuentaOrigen = CuentaOrigen;
        this.CuentaDestino = CuentaDestino;
        this.cantidad = cantidad;
        this.motivo = motivo;
    }
    
    public MovimientoBancario(){}
    
    public int getIdMovimientoBancario() {
        return idMovimientoBancario;
    }
    
     public void setIdMovimientoBancario(int idMovimientoBancario){
        this.idMovimientoBancario = idMovimientoBancario;
    }

    public int getCuentaOrigen() {
        return CuentaOrigen;
    }

    public void setCuentaOrigen(int CuentaOrigen) {
        this.CuentaOrigen = CuentaOrigen;
    }

    public int getCuentaDestino() {
        return CuentaDestino;
    }

    public void setCuentaDestino(int CuentaDestino) {
        this.CuentaDestino = CuentaDestino;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
