package com.clean.automation.core.driver;

import com.clean.automation.core.configuration.AppConfig;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by darjandjamtovski on 2/19/18.
 */
public class BrowserHandler {

    private AppConfig appConfig;

    public BrowserHandler() {
        appConfig = new AppConfig();
    }

    public void captureScreenshot(String screenshotName) throws IOException {
        String screenshotDirectory = appConfig.getProperty(AppConfig.SCREENSHOT_DIRECTORY);
        File screenshotDirectoryFile = new File(screenshotDirectory);

        if (!screenshotDirectoryFile.exists()) {
            screenshotDirectoryFile.mkdir();
        }

        String trimmedScreenshotName;
        if (screenshotName.length() > 150) {
            trimmedScreenshotName = screenshotName.substring(0, 150);
        } else {
            trimmedScreenshotName = screenshotName;
        }

        String timeStamp = getCurrentTimestamp();
        String screenshotExtension = appConfig.getProperty(AppConfig.SCREENSHOT_EXTENSION);
        String screenshotPath = String.format("%s%s%s-%s%s", screenshotDirectory, File.separator, trimmedScreenshotName, timeStamp, screenshotExtension);
        TakesScreenshot takesScreenshot = (TakesScreenshot) DriverManager.getDriver();
        File sourceScreenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationScreenshotFile = new File(screenshotPath);
        FileUtils.copyFile(sourceScreenshotFile, destinationScreenshotFile);
    }

    public void saveConsoleLog(String logName) throws IOException {
        LogEntries logEntries = DriverManager.getDriver().manage().logs().get("browser");
        String browserLogDirectory = appConfig.getProperty(AppConfig.BROWSER_LOG_DIRECTORY);

        File browserLogDirectoryFile = new File(browserLogDirectory);

        if (!browserLogDirectoryFile.exists()) {
            browserLogDirectoryFile.mkdir();
        }

        String trimmedLogName;
        if (logName.length() > 150) {
            trimmedLogName = logName.substring(0, 150);
        } else {
            trimmedLogName = logName;
        }

        String timeStamp = getCurrentTimestamp();
        String browserLogPath = String.format("%s%s%s%s.txt", browserLogDirectory, File.separator, trimmedLogName, timeStamp);

        List<LogEntry> logEntryList = logEntries.getAll();
        String logStringOutput = "";
        for (LogEntry logEntry :
                logEntryList) {
            logStringOutput += logEntry.getMessage() + "\n";
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(browserLogPath));
        bufferedWriter.write(logStringOutput);
        bufferedWriter.flush();
    }

    private String getCurrentTimestamp() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        Date date = new Date();
        String timestamp = dateFormat.format(date);

        return timestamp;
    }
}
