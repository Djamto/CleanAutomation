package com.clean.automation.pages;

import com.clean.automation.core.driver.ElementAllocator;
import com.clean.automation.core.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by darjandjamtovski on 2/11/18.
 */
public class AboutPage extends BasePage {

    public AboutPage() {
        super();
    }

    @Override
    public void open() {
        WebElement aboutButton = elementAllocator.getElementVisible(By.xpath("//nav[@id = 'access']//li//a[text() = 'About']"), ElementAllocator.WAIT_BY_CONFIGURATION);
        aboutButton.click();
    }
}
