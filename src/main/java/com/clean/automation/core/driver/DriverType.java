package com.clean.automation.core.driver;

/**
 * Created by darjandjamtovski on 2/11/18.
 */
public enum DriverType {

    Chrome("Chrome"),
    ChromeHeadless("ChromeHeadless");

    private String driverType;

    DriverType(String driverType) {
        this.driverType = driverType;
    }

    public String getDriver() {
        return driverType;
    }
}
