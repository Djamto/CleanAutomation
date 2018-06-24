package com.clean.automation.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by darjandjamtovski on 2/11/18.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "junit:target/cucumber.xml"},
        features = {
                "src/test/resources/features/SimpleTest.feature"
        },
        glue = {"com.clean.automation.steps", "com.clean.automation.core"},
        tags = {/*"@SimpleTest"*/}
)
public class TestRunner {
}
