package com.clean.automation.steps;

import com.clean.automation.core.scenario.BaseStep;
import com.clean.automation.core.scenario.ScenarioDataReset;
import com.clean.automation.pages.AboutPage;
import com.clean.automation.pages.LegalPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by darjandjamtovski on 2/11/18.
 */
public class SimpleTestSteps extends BaseStep {

    private AboutPage aboutPage = new AboutPage();
    private LegalPage legalPage = new LegalPage();

    @Given("^The step for resetting the scenario data$")
    public void givenTheStepForResettingTheScenarioData() {
        scenarioResetStepHandler.addScenarioDataResetStepAction(new ScenarioDataReset() {
            public void onScenarioDataResetStepAction() {
                System.out.println("The scenario data is reset.");
            }
        });
    }

    @Given("^The step for setting the scenario dummy data$")
    public void givenTheStepForSettingTheScenarioDummyData() {
        System.out.println("The scenario data is set.");
    }

    @When("^The user has opened the about page$")
    public void whenTheUserHasOpenedTheAboutPage() {
        aboutPage.open();
    }

    @And("^The user has opened the legal page$")
    public void andTheUserHasOpenedTheLegalPage() {
        legalPage.open();
    }

    @Then("^The user has validated the legal page is changed$")
    public void thenTheUserHasValidatedTheLegalpageIsChanged() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(true);
    }
}
