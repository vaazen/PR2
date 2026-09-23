package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

/**
 * /dropdown — обычный select с id="dropdown".
 */
public class DropdownPage {

    private final WebDriver driver;
    private final By dropdownLocator = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String baseUrl) {
        driver.get(baseUrl + "/dropdown");
    }

    private Select select() {
        return new Select(driver.findElement(dropdownLocator));
    }

    public List<String> getAllOptionsText() {
        return select().getOptions().stream()
                .map(org.openqa.selenium.WebElement::getText)
                .collect(Collectors.toList());
    }

    public void selectByIndex(int index) {
        select().selectByIndex(index);
    }

    public String getSelectedOptionText() {
        return select().getFirstSelectedOption().getText();
    }
}
