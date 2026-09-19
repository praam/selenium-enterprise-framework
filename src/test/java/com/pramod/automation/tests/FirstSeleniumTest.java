package com.pramod.automation.tests;

import com.pramod.automation.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstSeleniumTest extends BaseTest {

    @Test
    public void verifyApplicationTitle() {

        driver.get(configReader.getProperty("baseUrl"));

        String actualTitle = driver.getTitle();

        System.out.println("Application Title: " + actualTitle);

        Assert.assertEquals(actualTitle, "Swag Labs");
    }
}

