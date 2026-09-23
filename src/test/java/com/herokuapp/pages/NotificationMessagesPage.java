package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * /notification_message — клик по ссылке "Click here" показывает случайную
 * нотификацию (один из нескольких вариантов текста, меняется случайно).
 */
public class NotificationMessagesPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By clickHereLink = By.cssSelector("#content a");
    private final By notification = By.id("flash");

    public NotificationMessagesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open(String baseUrl) {
        driver.get(baseUrl + "/notification_message");
    }

    public void clickHere() {
        driver.findElement(clickHereLink).click();
    }

    /** Явное ожидание появления нотификации. */
    public String getNotificationText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(notification)).getText();
    }
}
