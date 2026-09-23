package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * /checkboxes — два чекбокса: первый изначально unchecked, второй checked.
 */
public class CheckboxesPage {

    private final WebDriver driver;

    private final By checkboxes = By.cssSelector("[type=checkbox]");

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String baseUrl) {
        driver.get(baseUrl + "/checkboxes");
    }

    private WebElement checkbox(int index) {
        List<WebElement> elements = driver.findElements(checkboxes);
        return elements.get(index);
    }

    public boolean isChecked(int index) {
        return checkbox(index).isSelected();
    }

    /** Кликает по чекбоксу, если его текущее состояние не совпадает с нужным. */
    public void setChecked(int index, boolean shouldBeChecked) {
        WebElement box = checkbox(index);
        if (box.isSelected() != shouldBeChecked) {
            box.click();
        }
    }
}
