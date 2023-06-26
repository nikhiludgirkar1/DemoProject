package com.demoproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommonLocators {
    private static WebDriver driver;

    public CommonLocators(WebDriver driver) {
        this.driver = driver;
    }

    public static boolean isLocatorNotVisible(WebElement locator) {
        return ExpectedConditions.not(ExpectedConditions.visibilityOf(locator)).apply(driver);
    }

    public static boolean isLocatorVisible(WebElement loc) {
        return loc.isDisplayed();
    }

}
