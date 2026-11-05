
package com.nttdata.steps;

import com.nttdata.screens.SauceLabsCartScreen;

public class SauceLabsCartSteps {

    private final SauceLabsCartScreen cartScreen =
            new SauceLabsCartScreen();

    // Validar que la galeria de productos cargue
    public boolean validarGaleriaProductos() {
        return cartScreen.galeriaCargada();
    }

    // Seleccionar un producto y agregar las unidades solicitadas
    public void agregarProductoAlCarrito(String producto, int unidades) {
        cartScreen.seleccionarProducto(producto);
        cartScreen.agregarProducto(unidades);
    }

    // Consultar los datos del producto agregado al carrito
    public String consultarNombreProductoCarrito() {
        cartScreen.abrirCarrito();
        return cartScreen.obtenerNombreProductoCarrito();
    }

    // Consultar la cantidad del producto en el carrito
    public String consultarCantidadProductoCarrito() {
        return cartScreen.obtenerCantidadProductoCarrito();
    }
}
