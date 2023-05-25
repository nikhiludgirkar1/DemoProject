package com.demoproject.hooks;

import com.demoproject.helper.api.DemoProjectConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.time.Duration;

public class DriverFactory {
    private WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public DriverFactory() {

    }

    public WebDriver getDriver() {
        return driver;
    }

    public void initializeBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(setChromeOptions());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DemoProjectConstants.PROPERTIES_CONFIG.maxPageLoadTimeoutInSec()));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(DemoProjectConstants.PROPERTIES_CONFIG.maxPageLoadTimeoutInSec()));
        }

        if (browserType.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver(setEdgeOptions());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DemoProjectConstants.PROPERTIES_CONFIG.maxPageLoadTimeoutInSec()));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(DemoProjectConstants.PROPERTIES_CONFIG.maxPageLoadTimeoutInSec()));
        }
    }

    public WebDriver setAndGetDriver() {
        if (DemoProjectConstants.PROPERTIES_CONFIG.browserType().equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            initializeBrowser("chrome");
        }

        if (DemoProjectConstants.PROPERTIES_CONFIG.browserType().equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            initializeBrowser("edge");
        }
        return getDriver();
    }

    public ChromeOptions setChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (DemoProjectConstants.PROPERTIES_CONFIG.headless())
            chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.setAcceptInsecureCerts(true);
        return chromeOptions;
    }

    public EdgeOptions setEdgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        if (DemoProjectConstants.PROPERTIES_CONFIG.headless())
            edgeOptions.addArguments("--headless");
        edgeOptions.addArguments("start-maximized");
        edgeOptions.setAcceptInsecureCerts(true);
        return edgeOptions;
    }
}
