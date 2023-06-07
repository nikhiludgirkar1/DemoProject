package com.demoproject.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.invoke.MethodHandles;

public class Hooks {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private WebDriver driver;
    private Scenario currentScenario;
    private String scenarioName;
    private static String featureName = "";

    public WebDriver getDriver() {
        return driver;
    }

    @Before
    public void setup() {
        this.driver = new DriverFactory().setAndGetDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        featureName = scenario.getUri().toString();
        logger.info("Scenario name is :: {}", scenario.getName());
        if (scenario.isFailed()) {
            byte[] data = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", scenario.getName());
        }
        driver.close();
        driver.quit();
    }
}
