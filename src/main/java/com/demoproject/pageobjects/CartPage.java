package com.demoproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;

public class CartPage {
    private WebDriver driver;
    private static final String CHECKOUT_BUTTON = "checkout";
    private static final String AVAILABLE_PRODUCT = "//div[@class='inventory_item_name'][contains(.,'%s')]";

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductAvailable(String productName) {
        WebElement descriptionElement = driver.findElement(By.xpath("//div[@class='cart_desc_label'][contains(.,'Description')]"));
        return driver.findElement(RelativeLocator.with(By.xpath(String.format(AVAILABLE_PRODUCT, productName))).below(descriptionElement)).isDisplayed();
    }

    public void clickCheckout() {
        driver.findElement(By.id(CHECKOUT_BUTTON)).click();
    }

    public void openInNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com/");
    }
}
