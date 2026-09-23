package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * /typos — параграф текста, который ИНОГДА (случайно, при обновлении страницы)
 * содержит опечатку. Сама страница демонстрирует нестабильность —
 * см. подсказку в задании: "проверяйте на допустимые варианты текста".
 */
public class TyposPage {

    private final WebDriver driver;
    private final By paragraph = By.tagName("p");

    public TyposPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String baseUrl) {
        driver.get(baseUrl + "/typos");
    }

    public String getParagraphText() {
        return driver.findElement(paragraph).getText();
    }
}
