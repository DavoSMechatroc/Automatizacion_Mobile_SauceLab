
package com.nttdata.hooks;

import com.nttdata.screens.AppConfigScreen;
import io.cucumber.java.After;

public class SauceLabsCartHooks {

    @After(value = "@Prueba001", order = 0)
    public void cerrarAplicacion() {

        try {
            AppConfigScreen appConfigScreen = new AppConfigScreen();

            appConfigScreen.cerrarAplicacion(
                    "com.saucelabs.mydemoapp.android"
            );

        } catch (Exception e) {
            System.out.println(
                    "No se pudo cerrar la aplicacion: " + e.getMessage()
            );
        }
    }
}

