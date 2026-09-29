package com.pramod.automation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage {

    private WebDriver driver;

    private By pageTitle = By.className("title");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
       return driver.findElement(pageTitle).getText();
    }

 public void addProductToCart(String productName) {

     By productNames = By.className("inventory_item_name");

     var products = driver.findElements(productNames);

     for (var product : products) {

        if (product.getText().trim().equals(productName)) {

            By addToCartButton = By.xpath(
                    "./ancestor::div[@class='inventory_item']"
                    + "//button"
            );

            product.findElement(addToCartButton).click();

            return;
         }
     }

    throw new RuntimeException(
            "Product was not found: " + productName
      );
   }

  public void clickCart() {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    By cartLink = By.className("shopping_cart_link");

    wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();

   }

   /*
 * DEBUGGING NOTE:
 *
 * If a browser alert unexpectedly appears before cart navigation,
 * temporarily use:
 *
 * try {
 *     Alert alert = driver.switchTo().alert();
 *     System.out.println("Alert text: " + alert.getText());
 *     alert.accept();
 * } catch (NoAlertPresentException e) {
 *     System.out.println("No alert detected.");
 * }
 *
 * Do not enable this unless the application actually requires
 * alert handling.
 */

}
