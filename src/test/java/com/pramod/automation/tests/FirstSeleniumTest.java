package com.pramod.automation.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pramod.automation.base.BaseTest;

public class FirstSeleniumTest extends BaseTest {

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

        pageObjectManager.getLoginPage().login("standard_user", "secret_sauce");

        Assert.assertEquals(pageObjectManager.getInventoryPage().getPageTitle(), "Products");

        List<String> products = Arrays.asList(
             "Sauce Labs Backpack",
                  "Sauce Labs Bike Light",
                  "Sauce Labs Bolt T-Shirt"
        );

        for (String product : products) {
           pageObjectManager.getInventoryPage().addProductToCart(product);
        }

        pageObjectManager.getInventoryPage().clickCart();

        System.out.println("Current URL: " + driver.getCurrentUrl());

        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page heading: " + pageObjectManager.getCartPage().getPageTitle());

        Assert.assertEquals(
       pageObjectManager.getCartPage().getPageTitle(),
        "Your Cart",
        "Cart page title is incorrect"
      );

       List<String> expectedProducts = Arrays.asList(
        "Sauce Labs Backpack",
        "Sauce Labs Bike Light",
        "Sauce Labs Bolt T-Shirt"
      );

      List<String> actualProducts = pageObjectManager.getCartPage().getCartProductNames();

      Assert.assertTrue(
        actualProducts.containsAll(expectedProducts),
        "Cart is missing expected products. Actual products: " + actualProducts
      );

      Assert.assertEquals(
        actualProducts.size(),
        expectedProducts.size(),
        "Cart product count is incorrect"
      );

      System.out.println("Cart page title: " + pageObjectManager.getCartPage().getPageTitle());
      System.out.println("Products in cart: " + actualProducts);

      pageObjectManager.getCartPage().clickCheckout();

      System.out.println("Checkout URL: " + driver.getCurrentUrl());

     pageObjectManager.getCheckoutPage().enterCustomerInformation(
        "Pramod",
        "QA",
        "D15ABC"
     );

     Assert.assertEquals(
        pageObjectManager.getCheckoutOverviewPage().getPageTitle(),
        "Checkout: Overview",
        "Checkout overview page title is incorrect"
     );

     List<String> actualOverviewProducts =
       pageObjectManager.getCheckoutOverviewPage().getProductNames();

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
        pageObjectManager.getCheckoutOverviewPage().getProductQuantities();

     List<String> expectedQuantities = Arrays.asList("1","1","1");

     Assert.assertEquals(
        actualQuantities,
        expectedQuantities,
        "Product quantities are incorrect. Actual quantities: "
         + actualQuantities
     );

     List<String> actualPrices =
       pageObjectManager.getCheckoutOverviewPage().getItemPrices();

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
        pageObjectManager.getCheckoutOverviewPage().getSubtotal(),
        "Item total: $55.97",
        "Subtotal is incorrect"
     );

    Assert.assertEquals(
        pageObjectManager.getCheckoutOverviewPage().getTax(),
        "Tax: $4.48",
        "Tax is incorrect"
    );

    Assert.assertEquals(
        pageObjectManager.getCheckoutOverviewPage().getTotal(),
        "Total: $60.45",
        "Final total is incorrect"
    );

    pageObjectManager.getCheckoutOverviewPage().clickFinish();

    Assert.assertEquals(
        pageObjectManager.getCheckoutCompletePage().getConfirmationTitle(),
        "Thank you for your order!",
        "Order confirmation title is incorrect"
    );

    Assert.assertTrue(
       pageObjectManager.getCheckoutCompletePage().getConfirmationMessage()
                .contains("Your order has been dispatched"),
        "Order confirmation message is incorrect"
    );

  }

}