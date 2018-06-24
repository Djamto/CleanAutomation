package com.clean.automation.core.page;

import com.clean.automation.core.configuration.AppConfig;
import com.clean.automation.core.driver.ElementAllocator;

/**
 * Created by darjandjamtovski on 2/11/18.
 */
public class BasePage implements PageInterface {

    protected ElementAllocator elementAllocator;
    protected AppConfig appConfig;

    public BasePage() {
        elementAllocator = new ElementAllocator();
        appConfig = new AppConfig();
    }

    public void open() {

    }
}
