
package com.nttdata.stepsdefinitions;

import com.nttdata.steps.AppConfigSteps;
import com.nttdata.steps.SauceLabsCartSteps;
import com.nttdata.support.ScreenshotAttacher;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SauceLabsCartStepDefs {

    private final AppConfigSteps appConfigSteps = new AppConfigSteps();
    private final SauceLabsCartSteps cartSteps = new SauceLabsCartSteps();

    private Scenario scenario;
    private String productoEsperado;
    private int unidadesEsperadas;

    @Before
    public void configurarScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicacionDeSauceLabs() {
        appConfigSteps.iniciarAplicacion("apkinfo.properties");
        ScreenshotAttacher.attach(scenario, "Pantalla inicial");
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoGaleriaProductos() {
        assertTrue(
                "No se cargo correctamente la galeria de productos",
                cartSteps.validarGaleriaProductos()
        );

        ScreenshotAttacher.attach(scenario, "Galeria de productos");
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agregoProductoAlCarrito(int unidades, String producto) {

        productoEsperado = producto;
        unidadesEsperadas = unidades;

        cartSteps.agregarProductoAlCarrito(producto, unidades);

        ScreenshotAttacher.attach(scenario, "Producto agregado");
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void validoCarritoDeCompra() {

        String productoActual = cartSteps.consultarNombreProductoCarrito();
        String cantidadActual = cartSteps.consultarCantidadProductoCarrito();

        // El nombre accesible de la camiseta no incluye el guion
        String nombreEsperado = productoEsperado;

        if (productoEsperado.equals("Sauce Labs Bolt - T-Shirt")) {
            nombreEsperado = "Sauce Labs Bolt T-Shirt";
        }

        assertEquals(
                "El producto del carrito no es el esperado",
                nombreEsperado,
                productoActual
        );

        assertEquals(
                "La cantidad del carrito no es la esperada",
                unidadesEsperadas,
                Integer.parseInt(cantidadActual.trim())
        );

        ScreenshotAttacher.attach(scenario, "Carrito validado");
    }
}
