package com.clean.automation.core.driver;

import com.clean.automation.core.configuration.AppConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by darjandjamtovski on 2/12/18.
 */
public class ElementAllocator {

    public static final Integer WAIT_BY_CONFIGURATION = null;

    private AppConfig appConfig = new AppConfig();

    public WebElement getElementVisible(By by, Integer secondsToWait) {
        if (secondsToWait == null) {
            secondsToWait = appConfig.getIntegerProperty(AppConfig.EXPLICIT_WAIT);
        }

        WebElement element;
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), secondsToWait);

        element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));

        return element;
    }

    public WebElement getElementPresent(By by, Integer secondsToWait) {
        if (secondsToWait == null) {
            secondsToWait = appConfig.getIntegerProperty(AppConfig.EXPLICIT_WAIT);
        }

        WebElement element;
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), secondsToWait);

        element = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));

        return element;
    }

    public WebElement getElementClickable(By by, Integer secondsToWait) {
        if (secondsToWait == null) {
            secondsToWait = appConfig.getIntegerProperty(AppConfig.EXPLICIT_WAIT);
        }

        WebElement element;
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), secondsToWait);

        element = webDriverWait.until(ExpectedConditions.elementToBeClickable(by));

        return element;
    }

    public List<WebElement> getElementsVisible(By by, Integer secondsToWait) {
        if (secondsToWait == null) {
            secondsToWait = appConfig.getIntegerProperty(AppConfig.EXPLICIT_WAIT);
        }

        List<WebElement> elements;
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), secondsToWait);

        elements = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

        return elements;
    }

    public List<WebElement> getElementsPresent(By by, Integer secondsToWait) {
        if (secondsToWait == null) {
            secondsToWait = appConfig.getIntegerProperty(AppConfig.EXPLICIT_WAIT);
        }

        List<WebElement> elements;
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), secondsToWait);

        elements = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));

        return elements;
    }
}
