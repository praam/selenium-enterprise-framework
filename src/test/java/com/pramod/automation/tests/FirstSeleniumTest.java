package com.pramod.automation.tests;

import com.pramod.automation.base.BaseTest;
import com.pramod.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void initializePageObjects() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void verifyApplicationTitle() {

        driver.get(configReader.getProperty("baseUrl"));

        String actualTitle = driver.getTitle();

        System.out.println("Application Title: " + actualTitle);

        Assert.assertEquals(actualTitle, "Swag Labs");
    }

    @Test
    public void verifyValidLogin() {

        driver.get(configReader.getProperty("baseUrl"));

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }
}