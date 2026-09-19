package com.pramod.automation.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private final Properties properties;

    public ConfigReader() {

        properties = new Properties();

        try (InputStream inputStream =
                     getClass().getClassLoader()
                             .getResourceAsStream("config/config.properties")) {

            if (inputStream == null) {
                throw new RuntimeException(
                        "Configuration file not found: config/config.properties"
                );
            }

            properties.load(inputStream);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to load configuration file",
                    e
            );
        }
    }

    public String getProperty(String key) {

        return properties.getProperty(key);
    }
}