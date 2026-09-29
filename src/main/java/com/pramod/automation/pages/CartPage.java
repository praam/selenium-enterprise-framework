package com.pramod.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class CartPage {

    private WebDriver driver;

    private By pageTitle = By.className("title");
    private By cartItems = By.className("inventory_item_name");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public List<String> getCartProductNames() {

        return driver.findElements(cartItems)
               .stream()
               .map(element -> element.getText().trim())
               .toList();
    }

    public void clickCheckout() {

    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

    wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();

    }
}
