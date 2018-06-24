package com.clean.automation.core.driver;

import com.clean.automation.core.configuration.AppConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

/**
 * Created by darjandjamtovski on 2/11/18.
 */
public class DriverManager {

    private final String CHROME_DRIVER_EXECUTABLE = "chromedriver";

    private AppConfig appConfig;
    private static WebDriver driver = null;

    public void initializeWebDriver() {
        appConfig = new AppConfig();
        String driverName = appConfig.getProperty(AppConfig.DRIVER_NAME);
        DriverType driverType = DriverType.valueOf(driverName);

        switch (driverType) {
            case Chrome:
                ChromeDriverService chromeDriverService =
                        new ChromeDriverService.Builder()
                                .usingDriverExecutable(new File(getDriverPath(CHROME_DRIVER_EXECUTABLE)))
                                .usingAnyFreePort()
                                .build();

                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.merge(capabilities);

                driver = new ChromeDriver(chromeDriverService, chromeOptions);
                break;
            case ChromeHeadless:
                ChromeDriverService chromeDriverService1 =
                        new ChromeDriverService.Builder()
                                .usingDriverExecutable(new File(getDriverPath(CHROME_DRIVER_EXECUTABLE)))
                                .usingAnyFreePort()
                                .build();

                DesiredCapabilities capabilities1 = DesiredCapabilities.chrome();
                ChromeOptions chromeOptions1 = new ChromeOptions();
                chromeOptions1.merge(capabilities1);
                chromeOptions1.addArguments("headless", "disable-gpu");

                driver = new ChromeDriver(chromeDriverService1, chromeOptions1);
                break;
        }

        if (driver == null) {
            throw new RuntimeException("The web driver is not properly initialized, make sure the web driver is properly initialized. Error: WebDriver is null.");
        }

        driver.manage().window().maximize();
    }

    public void destroyWebDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    private String getDriverPath(String driverExecutable) {
        String driverAbsolutePath;
        String resourcePath;
        ClassLoader classLoader = getClass().getClassLoader();
        resourcePath = String.format("driver/%s", driverExecutable);
        File file = new File(classLoader.getResource(resourcePath).getFile());
        driverAbsolutePath = file.getAbsolutePath();

        return driverAbsolutePath;
    }
}
