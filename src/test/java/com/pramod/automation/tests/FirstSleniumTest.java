package com.pramod.automation.tests;

import com.pramod.automation.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstSleniumTest extends BaseTest{
    
    @Test
    public void verifyapplicarionTitle() {

        // Navigate to the application URL
        driver.get("https://www.saucedemo.com/");

        // Get the title of the page
        String actualTitle = driver.getTitle();

        System.out.println("Application Title: " + actualTitle);

        // Assert the title (you can use TestNG assertions)
        Assert.assertEquals(actualTitle,"Swag Labs");

    }

}
