package com.clean.automation.core.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * Created by darjandjamtovski on 2/11/18.
 */
public class AppConfig {

    public static final String DRIVER_NAME = "driver.name";
    public static final String APPLICATION_URL = "application.url";
    public static final String EXPLICIT_WAIT = "explicit.wait";
    public static final String SCREENSHOT_DIRECTORY = "screenshot.directory";
    public static final String SCREENSHOT_EXTENSION = "screenshot.extension";
    public static final String BROWSER_LOG_DIRECTORY = "browser.log.directory";

    private final String CONFIGURATION_FILE_NAME = "automation.properties";

    public int getIntegerProperty(String propertyKey) {
        String property = getProperty(propertyKey);
        int integerProperty = Integer.parseInt(property);

        return integerProperty;
    }

    public String getProperty(String propertyKey) {
        Properties properties = new Properties();
        InputStream inputStream = null;
        String result = null;

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            String configurationFilePath = String.format("configuration/%s", CONFIGURATION_FILE_NAME);
            URL fileURL = classLoader.getResource(configurationFilePath);
            File file = new File(fileURL.getFile());

            inputStream = new FileInputStream(file);
            properties.load(inputStream);
            result = properties.getProperty(propertyKey);
        } catch (IOException e) {
            return null;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
}
