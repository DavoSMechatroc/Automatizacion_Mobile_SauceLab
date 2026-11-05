
package com.nttdata.screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SauceLabsCartScreen extends BaseScreen {

    // Localizadores de la galeria
    private final By tituloProductos =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/productTV");

    // Localizadores del detalle del producto
    private final By botonAumentarCantidad =
            AppiumBy.accessibilityId("Increase item quantity");

    private final By cantidadProducto =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/noTV");

    private final By botonAgregarCarrito =
            AppiumBy.accessibilityId("Tap to add product to cart");

    private final By iconoCarrito =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartIV");

    // Localizadores del carrito
    private final By nombreProductoCarrito =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/titleTV");

    private final By cantidadProductoCarrito =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/noTV");

    // Validar que la galeria se haya cargado
    public boolean galeriaCargada() {
        return waitForVisible(tituloProductos)
                .getText()
                .equals("Products");
    }

    // Seleccionar un producto por su nombre
    public void seleccionarProducto(String nombreProducto) {

        String nombreAccesibilidad = nombreProducto;

        if (nombreProducto.equals("Sauce Labs Bolt - T-Shirt")) {
            nombreAccesibilidad = "Sauce Labs Bolt T-Shirt";
        }

        By producto = AppiumBy.accessibilityId(nombreAccesibilidad);

        waitForVisible(producto).click();
    }

    public void agregarProducto(int unidades) {

        for (int i = 1; i < unidades; i++) {
            waitForVisible(botonAumentarCantidad).click();
        }

        waitForVisible(botonAgregarCarrito).click();
    }

    // Abrir el carrito de compras
    public void abrirCarrito() {
        waitForVisible(iconoCarrito).click();
    }

    // Obtener el nombre del producto en el carrito
    public String obtenerNombreProductoCarrito() {
        WebElement producto = waitForVisible(nombreProductoCarrito);
        return producto.getText();
    }

    // Obtener la cantidad del producto en el carrito
    public String obtenerCantidadProductoCarrito() {
        WebElement cantidad = waitForVisible(cantidadProductoCarrito);
        return cantidad.getText();
    }
}
