package com.example.carrito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ProcesadorDeCarritoTest {

    private CarritoDeCompras carritoMock;
    private ProcesadorDeCarrito procesador;

    @Before
    public void setUp() {
        carritoMock = Mockito.mock(CarritoDeCompras.class);
        procesador = new ProcesadorDeCarrito(carritoMock);
    }

    @Test
    public void aplicarDescuento_CuandoTotalEsMayorOIgualA100_DeberiaAplicar10PorCiento() {
        // Arrange
        Mockito.when(carritoMock.calcularTotal()).thenReturn(150.0);

        // Act
        double totalConDescuento = procesador.aplicarDescuento(10.0);

        // Assert
        assertEquals(135.0, totalConDescuento, 0.01);
        Mockito.verify(carritoMock).calcularTotal();
    }

    @Test
    public void aplicarDescuento_CuandoTotalEsMenorA100_NoAplicaDescuento() {
        // Arrange
        Mockito.when(carritoMock.calcularTotal()).thenReturn(80.0);

        // Act
        double totalConDescuento = procesador.aplicarDescuento(0);

        // Assert
        assertEquals(80.0, totalConDescuento, 0.01);
        Mockito.verify(carritoMock).calcularTotal();
    }

    @Test
    public void calificaParaEnvioGratis_CuandoTotalEsMayorOIgualA200_DeberiaSerVerdadero() {
        // Arrange
        Mockito.when(carritoMock.calcularTotal()).thenReturn(250.0);

        // Act
        boolean califica = procesador.calificaParaEnvioGratis();

        // Assert
        assertTrue(califica);
        Mockito.verify(carritoMock).calcularTotal();
    }

    @Test
    public void calificaParaEnvioGratis_CuandoTotalEsMenorA100_DeberiaSerFalso() {
        // Arrange
        Mockito.when(carritoMock.calcularTotal()).thenReturn(50.0);

        // Act
        boolean califica = procesador.calificaParaEnvioGratis();

        // Assert
        assertFalse(califica);
        Mockito.verify(carritoMock).calcularTotal();
    }

}
