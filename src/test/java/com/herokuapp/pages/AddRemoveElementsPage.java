package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * /add_remove_elements/ — динамическое добавление и удаление кнопок "Delete".
 */
public class AddRemoveElementsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By addElementButton = By.xpath("//button[text()='Add Element']");
    private final By deleteButtons = By.xpath("//button[text()='Delete']");

    public AddRemoveElementsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open(String baseUrl) {
        driver.get(baseUrl + "/add_remove_elements/");
    }

    public void clickAddElement() {
        wait.until(ExpectedConditions.elementToBeClickable(addElementButton)).click();
    }

    /** Кликает по первой попавшейся кнопке Delete. */
    public void clickFirstDelete() {
        List<org.openqa.selenium.WebElement> buttons = driver.findElements(deleteButtons);
        wait.until(ExpectedConditions.elementToBeClickable(buttons.get(0))).click();
    }

    public int getDeleteButtonsCount() {
        return driver.findElements(deleteButtons).size();
    }
}
