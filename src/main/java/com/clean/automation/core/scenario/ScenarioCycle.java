package com.clean.automation.core.scenario;

import com.clean.automation.core.configuration.AppConfig;
import com.clean.automation.core.driver.BrowserHandler;
import com.clean.automation.core.driver.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by darjandjamtovski on 2/12/18.
 */
public class ScenarioCycle {

    private static DriverManager driverManager = new DriverManager();
    private BrowserHandler browserHandler = new BrowserHandler();
    private AppConfig appConfig = new AppConfig();

    @Before(order = 100)
    public void initializeWebDriverBeforeStep() {
        driverManager.initializeWebDriver();
    }

    @Before(order = 300)
    public void navigateToApplicationBeforeStep() throws MalformedURLException {
        navigateToApplication();
    }


    @After(order = 300)
    public void captureScreenshotAfterScenario(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            browserHandler.captureScreenshot(scenario.getName());
            browserHandler.saveConsoleLog(scenario.getName());
        }
    }

    @After(order = 200)
    public void executeAfterScenarioListener() {
        List<ScenarioDataReset> scenarioDataResetList = ScenarioResetStepHandler.getScenarioDataResetList();
        for (ScenarioDataReset scenarioDataReset : scenarioDataResetList) {
            scenarioDataReset.onScenarioDataResetStepAction();
        }
    }

    @After(order = 100)
    public void destroyWebDriver() {
        driverManager.destroyWebDriver();
    }

    private void navigateToApplication() throws MalformedURLException {
        URL url = new URL(appConfig.getProperty(AppConfig.APPLICATION_URL));
        DriverManager.getDriver().navigate().to(url);
    }
}
