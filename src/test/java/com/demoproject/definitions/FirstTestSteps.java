package com.demoproject.definitions;

import com.demoproject.helper.api.ApiSetup;
import com.demoproject.helper.api.Endpoints;
import com.demoproject.hooks.Hooks;
import com.demoproject.pageobjects.FirstStepsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstTestSteps {
    private WebDriver driver;
    private final FirstStepsPage firstStepsPage;
    private HashMap<String, String> endpointData;
    Hooks localHooks;
    Response response;

    public FirstTestSteps(Hooks hooks) {
        localHooks = hooks;
        driver = localHooks.getDriver();
        endpointData = ApiSetup.getData();
        firstStepsPage = new FirstStepsPage(driver);
    }

    @When("user navigates to google.com")
    public void userNavigates() {
        firstStepsPage.accessUrl();
    }

    @When("user clicks on images")
    public void userClicksOnImages() {
        firstStepsPage.clickImage();
    }

    @Then("images page is loaded")
    public void imagesPageIsLoaded() {
        assertTrue(firstStepsPage.isImagesPageLoaded());
    }


}