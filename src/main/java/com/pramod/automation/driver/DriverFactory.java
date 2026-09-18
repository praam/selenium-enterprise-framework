package com.pramod.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private WebDriver driver;

    
    public void initializeDriver() {

        driver = new ChromeDriver();

    }

    public WebDriver getDriver() {

        return driver;

    }

    public void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }
    
}
