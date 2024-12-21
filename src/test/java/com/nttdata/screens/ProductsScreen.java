package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Collections;
import io.appium.java_client.AppiumDriver;

public class ProductsScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/productTV\"]")

    private WebElement lblProduct;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/*")
    private List<WebElement> viewGroup;

    private String producto = "//android.widget.ImageView[@content-desc='%s']";

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to add product to cart\"]")
    private WebElement agregar;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Increase item quantity\"]")
    private WebElement cantidadProducto;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@content-desc=\"View cart\"]")
    private WebElement verCarrito;



    public boolean isProductDisplayed() {
        waitFor(ExpectedConditions.visibilityOf(lblProduct));
        return lblProduct.isEnabled();
    }

    public void listaProductos() {
        System.out.println("Cantidad de RecyclerViews encontrados: " + viewGroup.size());

        if (viewGroup.size() <= 0) {
            System.out.println("No se cargó la lista correctamente");
        }
    }

    public void seleccionarProducto(String producto) {
        buscarElemento(producto).click();
    }

    public WebElement buscarElemento(String nombre) {
        String productoABuscar = String.format(producto, nombre);
        WebElement element = getDriver().findElement(By.xpath(productoABuscar));
        System.out.println("Elemento encontrado: " + element.getTagName() + " | Texto: " + element.getText());
        return element;
    }

    public void agregarAlCarrito() {
        agregar.click();
    }

    public void selecionarCantidad(int cantidad) {
        ScrollUtils scroll = new ScrollUtils(getDriver());
        for (int i=1; i<cantidad;i++){
            scroll.scrollAndClickById("com.saucelabs.mydemoapp.android:id/plusIV");
        }
    }


    public void esperar(int tiempoEnSegundos) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(tiempoEnSegundos));
        wait.until(webDriver -> true);
    }

    public void scrollAndClickAgregar() {
        ScrollUtils scroll = new ScrollUtils(getDriver());
        scroll.scrollAndClickById("com.saucelabs.mydemoapp.android:id/plusIV");
    }


    //Sin uso
    public void selecionarCarrito() {
        verCarrito.click();
    }

}
