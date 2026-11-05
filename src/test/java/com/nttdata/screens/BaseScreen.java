
package com.nttdata.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseScreen {

    protected static final Duration TIMEOUT = Duration.ofSeconds(20);

    protected AndroidDriver driver() {
        return AppConfigScreen.getDriver();
    }

    protected WebElement waitForVisible(By locator) {
        return new WebDriverWait(driver(), TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
