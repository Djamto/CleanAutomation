package com.clean.automation.pages;

import com.clean.automation.core.driver.ElementAllocator;
import com.clean.automation.core.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by darjandjamtovski on 2/11/18.
 */
public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    @Override
    public void open() {
        WebElement blogButton = elementAllocator.getElementVisible(By.xpath("//nav[@id = 'access']//li//a[text() = 'Blog']"), ElementAllocator.WAIT_BY_CONFIGURATION);
        blogButton.click();
    }
}
