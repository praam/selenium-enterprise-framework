package com.pramod.automation.tests;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pramod.automation.base.BaseTest;
import com.pramod.automation.pages.CartPage;
import com.pramod.automation.pages.CheckoutCompletePage;
import com.pramod.automation.pages.CheckoutOverviewPage;
import com.pramod.automation.pages.CheckoutPage;
import com.pramod.automation.pages.InventoryPage;
import com.pramod.automation.pages.LoginPage;

public class FirstSeleniumTest extends BaseTest {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;

    @BeforeMethod
    public void initializePageObjects() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        }

    @Test
    public void verifyApplicationTitle() {

        driver.get(configReader.getProperty("baseUrl"));

        String actualTitle = driver.getTitle();

        System.out.println("Application Title: " + actualTitle);

        Assert.assertEquals(actualTitle, "Swag Labs");
        }

    @Test
    public void verifyProductsCanBeAddedToCart() {

        driver.get(configReader.getProperty("baseUrl"));

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertEquals(inventoryPage.getPageTitle(), "Products");

        List<String> products = Arrays.asList(
             "Sauce Labs Backpack",
                  "Sauce Labs Bike Light",
                  "Sauce Labs Bolt T-Shirt"
        );

        for (String product : products) {
            inventoryPage.addProductToCart(product);
        }

        inventoryPage.clickCart();

        System.out.println("Current URL: " + driver.getCurrentUrl());

        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page heading: " + cartPage.getPageTitle());

        Assert.assertEquals(
        cartPage.getPageTitle(),
        "Your Cart",
        "Cart page title is incorrect"
      );

       List<String> expectedProducts = Arrays.asList(
        "Sauce Labs Backpack",
        "Sauce Labs Bike Light",
        "Sauce Labs Bolt T-Shirt"
      );

      List<String> actualProducts = cartPage.getCartProductNames();

      Assert.assertTrue(
        actualProducts.containsAll(expectedProducts),
        "Cart is missing expected products. Actual products: " + actualProducts
      );

      Assert.assertEquals(
        actualProducts.size(),
        expectedProducts.size(),
        "Cart product count is incorrect"
      );

      System.out.println("Cart page title: " + cartPage.getPageTitle());
      System.out.println("Products in cart: " + actualProducts);

      cartPage.clickCheckout();

      System.out.println("Checkout URL: " + driver.getCurrentUrl());

      checkoutPage.enterCustomerInformation(
        "Pramod",
        "QA",
        "D15ABC"
     );

     Assert.assertEquals(
        checkoutOverviewPage.getPageTitle(),
        "Checkout: Overview",
        "Checkout overview page title is incorrect"
     );

     List<String> actualOverviewProducts =
        checkoutOverviewPage.getProductNames();

     Assert.assertTrue(
        actualOverviewProducts.containsAll(expectedProducts),
        "Checkout overview is missing expected products. Actual products: "
                + actualOverviewProducts
     );

     Assert.assertEquals(
        actualOverviewProducts.size(),
        expectedProducts.size(),
        "Checkout overview product count is incorrect"
     );

     List<String> actualQuantities =
        checkoutOverviewPage.getProductQuantities();

     List<String> expectedQuantities = Arrays.asList("1","1","1");

     Assert.assertEquals(
        actualQuantities,
        expectedQuantities,
        "Product quantities are incorrect. Actual quantities: "
         + actualQuantities
     );

     List<String> actualPrices =
        checkoutOverviewPage.getItemPrices();

     List<String> expectedPrices = Arrays.asList(
        "$29.99",
        "$9.99",
        "$15.99"
     );

     Assert.assertEquals(
        actualPrices,
        expectedPrices,
        "Product prices are incorrect. Actual prices: " + actualPrices
     );

     Assert.assertEquals(
        checkoutOverviewPage.getSubtotal(),
        "Item total: $55.97",
        "Subtotal is incorrect"
     );

    Assert.assertEquals(
        checkoutOverviewPage.getTax(),
        "Tax: $4.48",
        "Tax is incorrect"
    );

    Assert.assertEquals(
        checkoutOverviewPage.getTotal(),
        "Total: $60.45",
        "Final total is incorrect"
    );

    checkoutOverviewPage.clickFinish();

    Assert.assertEquals(
        checkoutCompletePage.getConfirmationTitle(),
        "Thank you for your order!",
        "Order confirmation title is incorrect"
    );

    Assert.assertTrue(
        checkoutCompletePage.getConfirmationMessage()
                .contains("Your order has been dispatched"),
        "Order confirmation message is incorrect"
    );

  }

}