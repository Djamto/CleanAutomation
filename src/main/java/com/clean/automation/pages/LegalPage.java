package com.clean.automation.pages;

import com.clean.automation.core.driver.ElementAllocator;
import com.clean.automation.core.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by darjandjamtovski on 2/11/18.
 */
public class LegalPage extends BasePage {

    public LegalPage() {
        super();
    }

    @Override
    public void open() {
        WebElement legalButton = elementAllocator.getElementVisible(By.xpath("//nav[@id = 'access']//li//a[text() = 'Legal stuff']"), ElementAllocator.WAIT_BY_CONFIGURATION);
        legalButton.click();
    }
}
