package com.pramod.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstSleniumTest {
    
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Initialize the WebDriver here (e.g., ChromeDriver, FirefoxDriver, etc.)
        // Example: driver = new ChromeDriver();
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
          driver.manage().window().maximize();

    }

    @Test
    public void verifyapplicarionTitle() {

        // Navigate to the application URL
        driver.get("https://www.saucedemo.com/");

        // Get the title of the page
        String pageTitle = driver.getTitle();

        // Assert the title (you can use TestNG assertions)
        Assert.assertEquals(pageTitle,"Swag Labs");

    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after the test
        if (driver != null) {

            driver.quit();
            
        }
    }


}
