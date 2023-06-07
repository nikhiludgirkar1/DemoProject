package com.demoproject.pageobjects;

import com.demoproject.helper.api.DemoProjectConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class LoginPage {
    private static final String GMAIL_LINK = "//a[contains(.,'Gmail')]";

    private static final String USERNAME_TEXTBOX = "user-name";
    private static final String PASSWORD_TEXTBOX = "password";
    private static final String LOGIN_BUTTON = "login-button";
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
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

    //added comment
    public void setUserName(String userName) {
        driver.findElement(By.id(USERNAME_TEXTBOX)).sendKeys(userName);
    }

    public void setPassword(String password) {
        driver.findElement(By.id(PASSWORD_TEXTBOX)).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.id(LOGIN_BUTTON)).click();
    }


}
