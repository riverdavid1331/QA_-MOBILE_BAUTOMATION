package com.nttdata.screens;


import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollUtils {
    WebDriver driver;

    public ScrollUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollAndClickById(String elementId) {
        driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                                ".scrollIntoView(new UiSelector().resourceId(\"" + elementId + "\"))"))
                .click();
    }

}