package com.example.carrito;

public class ProcesadorDeCarrito {
    private CarritoDeCompras carrito;

    public ProcesadorDeCarrito(CarritoDeCompras carrito) {
        this.carrito = carrito;
    }

    public double aplicarDescuento(double porcentaje) {
        double total = carrito.calcularTotal();
        return total - (total * (porcentaje / 100));
    }

    public boolean calificaParaEnvioGratis() {
        return carrito.calcularTotal() >= 100.0;
    }
}

