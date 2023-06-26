package com.demoproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private static final String TWITTER_ICON = "//a[contains(.,'Twitter')]";
    private static final String ADD_TO_CART = "//button[@name='add-to-cart-sauce-labs-%s'][contains(.,'Add to cart')]";
    private static final String SHOPPING_CART_LINK = "//a[@class='shopping_cart_link']";
    private SynchronizationHelper synchronizationHelper;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        synchronizationHelper = new SynchronizationHelper(driver);
    }

    public boolean isLoginSuccessful() {
        WebElement twitterIcon = driver.findElement(By.xpath(TWITTER_ICON));
        SynchronizationHelper.waitForElementToBePresent(RelativeLocator.with(By.tagName("div")).below(twitterIcon));
        return driver.findElement(RelativeLocator.with(By.tagName("div")).below(twitterIcon)).isDisplayed();
    }

    public void clickAddToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART, productName))).click();
    }

    public void clickCartLink() {
        driver.findElement(By.xpath(SHOPPING_CART_LINK)).click();
    }

}
