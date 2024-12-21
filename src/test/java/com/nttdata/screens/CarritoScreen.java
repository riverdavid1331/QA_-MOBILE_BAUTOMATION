package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

//package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarritoScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/productTV\"]")
    private WebElement titulo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/priceTV\"]")
    private WebElement precio;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/noTV\"]")
    private WebElement cantidad;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/totalPriceTV\"]")
    private WebElement montoTotal;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Confirms products for checkout\"]")
    private WebElement pagar;

    public boolean isCarritoDisplayed(){
        waitFor(ExpectedConditions.visibilityOf(titulo));
        return titulo.isEnabled();
    }

    public double obtenerNumero(WebElement elemento) {
        String texto = elemento.getText();

        String numerico = texto.replaceAll("[^0-9.]", "");
        return Double.parseDouble(numerico);
    }

    public boolean esCorrectoMontoTotal(double valorEsperado) {
        double montoMostrado = obtenerNumero(precio)*obtenerNumero(cantidad);
        System.out.println(montoMostrado);
        Assert.assertEquals("El monto total mostrado no es correcto", valorEsperado, montoMostrado, 0.01);
        return true;
    }
    public void pagarCompra(){
        pagar.click();
    }

    public void esperar(int tiempoEnSegundos) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(tiempoEnSegundos));
        wait.until(webDriver -> true);
    }
}