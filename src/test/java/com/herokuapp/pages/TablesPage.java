package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * /tables — на странице две одинаковые по структуре таблицы. Работаем с первой.
 * Локаторы вида //table[1]//tr[N]//td[M] — как указано в задании.
 */
public class TablesPage {

    private final WebDriver driver;

    public TablesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String baseUrl) {
        driver.get(baseUrl + "/tables");
    }

    /** row и col — 1-based, как в самом XPath (первая строка данных — row=1, не считая заголовка). */
    public String getCellText(int table, int row, int col) {
        By cellLocator = By.xpath(
                "//table[" + table + "]//tbody//tr[" + row + "]//td[" + col + "]");
        return driver.findElement(cellLocator).getText();
    }
}
