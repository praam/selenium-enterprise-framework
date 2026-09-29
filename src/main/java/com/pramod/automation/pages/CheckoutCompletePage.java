package com.pramod.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    private WebDriver driver;

    private By confirmationTitle = By.className("complete-header");
    private By confirmationMessage = By.className("complete-text");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getConfirmationTitle() {
        return driver.findElement(confirmationTitle).getText();
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }
}