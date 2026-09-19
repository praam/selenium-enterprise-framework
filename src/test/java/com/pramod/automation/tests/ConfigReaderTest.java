package com.pramod.automation.tests;

import com.pramod.automation.config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigReaderTest {

    @Test
    public void verifyConfigurationProperties() {

        ConfigReader configReader = new ConfigReader();

        String browser = configReader.getProperty("browser");
        String baseUrl = configReader.getProperty("baseUrl");

        System.out.println("Browser: " + browser);
        System.out.println("Base URL: " + baseUrl);

        Assert.assertEquals(browser, "chrome");
        Assert.assertEquals(baseUrl, "https://www.saucedemo.com/");
    }
}
