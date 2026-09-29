package com.pramod.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CheckoutOverviewPage {

    private WebDriver driver;

    private By pageTitle = By.className("title");
    private By cartItems = By.className("inventory_item_name");
    private By itemPrices = By.className("inventory_item_price");
    private By itemQuantities = By.className("cart_quantity");
    private By subtotalLabel = By.className("summary_subtotal_label");
    private By taxLabel = By.className("summary_tax_label");
    private By totalLabel = By.className("summary_total_label");
    private By finishButton = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public List<String> getProductNames() {

    return driver.findElements(cartItems)
            .stream()
            .map(element -> element.getText().trim())
            .toList();
   }

    public List<String> getProductQuantities() {

    return driver.findElements(itemQuantities)
            .stream()
            .map(element -> element.getText().trim())
            .toList();
   }

   public List<String> getItemPrices() {

    return driver.findElements(itemPrices)
            .stream()
            .map(element -> element.getText().trim())
            .toList();
    }

    public String getSubtotal() {
    return driver.findElement(subtotalLabel).getText();
    }

    public String getTax() {
    return driver.findElement(taxLabel).getText();
    }

    public String getTotal() {
    return driver.findElement(totalLabel).getText();
    }

    public void clickFinish() {
    driver.findElement(finishButton).click();
}


}
