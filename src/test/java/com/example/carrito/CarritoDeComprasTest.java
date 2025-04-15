package com.example.carrito;

import org.junit.Assert;
import org.junit.Test;

public class CarritoDeComprasTest {

    @Test
    public void testAgregarProducto() {
        CarritoDeCompras carrito = new CarritoDeCompras();
        Producto p1 = new Producto("Mouse", 25.0);

        carrito.agregarProducto(p1);

        Assert.assertEquals(1, carrito.cantidadDeProductos());
    }

    @Test
    public void testCalcularTotal() {
        CarritoDeCompras carrito = new CarritoDeCompras();
        carrito.agregarProducto(new Producto("Mouse", 25.0));
        carrito.agregarProducto(new Producto("Teclado", 75.0));

        Assert.assertEquals(100.0, carrito.calcularTotal(), 0.001);
    }
}
