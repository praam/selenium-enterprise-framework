package com.pramod.automation.base;

import com.pramod.automation.config.ConfigReader;
import com.pramod.automation.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected DriverFactory driverFactory;
    protected WebDriver driver;
    protected ConfigReader configReader;

    @BeforeMethod
    public void setUp() {

        configReader = new ConfigReader();

        String browser = configReader.getProperty("browser");

        driverFactory = new DriverFactory();

        driverFactory.initializeDriver(browser);

        driver = driverFactory.getDriver();

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {

        if (driverFactory != null) {
            driverFactory.quitDriver();
        }
    }
}