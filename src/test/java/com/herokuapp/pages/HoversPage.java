package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * /hovers — 3 карточки профилей. При наведении (hover) появляется подпись
 * с именем и ссылка "View profile". Используем класс Actions для hover,
 * как указано в задании.
 */
public class HoversPage {

    private final WebDriver driver;

    private final By figures = By.className("figure");
    private final By captionName = By.tagName("h5");
    private final By profileLink = By.tagName("a");

    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String baseUrl) {
        driver.get(baseUrl + "/hovers");
    }

    public int getFiguresCount() {
        return driver.findElements(figures).size();
    }

    private WebElement figure(int index) {
        return driver.findElements(figures).get(index);
    }

    public void hoverOverFigure(int index) {
        new Actions(driver).moveToElement(figure(index)).perform();
    }

    public String getCaptionName(int index) {
        return figure(index).findElement(captionName).getText();
    }

    /** Возвращает href ссылки "View profile" — переходить будем через driver.get(). */
    public String getProfileLinkHref(int index) {
        return figure(index).findElement(profileLink).getAttribute("href");
    }
}
