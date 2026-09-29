package com.pramod.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class DriverFactory {

    private WebDriver driver;

    public void initializeDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {

    ChromeOptions options = new ChromeOptions();

    options.addArguments("--disable-notifications");

    options.setExperimentalOption(
            "prefs",
            Map.of(
                    "credentials_enable_service", false,
                    "profile.password_manager_leak_detection", false,
                    "profile.password_manager_enabled", false
            )
    );

    driver = new ChromeDriver(options);

   }

else {

            throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
            );
        }
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
