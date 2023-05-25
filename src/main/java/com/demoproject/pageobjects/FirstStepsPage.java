package com.demoproject.pageobjects;

import com.demoproject.helper.api.DemoProjectConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class FirstStepsPage {
    private static final String GMAIL_LINK = "//a[contains(.,'Gmail')]";
    private WebDriver driver;
    public FirstStepsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickImage() {
        WebElement gmail = driver.findElement(By.xpath(GMAIL_LINK));
        driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(gmail)).click();
    }

    public void accessUrl() {
        driver.navigate().to(DemoProjectConstants.PROPERTIES_CONFIG.portalUrl());
    }

    public boolean isImagesPageLoaded() {
        return driver.findElement(By.xpath("//img[@alt='Google Images']")).isDisplayed();
    }

}
