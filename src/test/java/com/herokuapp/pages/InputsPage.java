package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * /inputs — числовое поле (type=number), поддерживает Keys.ARROW_UP/ARROW_DOWN.
 */
public class InputsPage {

    private final WebDriver driver;
    private final By inputLocator = By.tagName("input");

    public InputsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String baseUrl) {
        driver.get(baseUrl + "/inputs");
    }

    private WebElement input() {
        return driver.findElement(inputLocator);
    }

    public void enterValue(String value) {
        WebElement el = input();
        el.clear();
        el.sendKeys(value);
    }

    public void pressArrowUp() {
        input().sendKeys(Keys.ARROW_UP);
    }

    public void pressArrowDown() {
        input().sendKeys(Keys.ARROW_DOWN);
    }

    public String getValue() {
        return input().getAttribute("value");
    }
}
