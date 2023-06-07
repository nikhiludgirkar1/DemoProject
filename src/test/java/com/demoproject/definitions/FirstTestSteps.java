package com.demoproject.definitions;

import com.demoproject.helper.api.ApiSetup;
import com.demoproject.hooks.Hooks;
import com.demoproject.pageobjects.CartPage;
import com.demoproject.pageobjects.LandingPage;
import com.demoproject.pageobjects.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstTestSteps {
    private WebDriver driver;
    private final LoginPage loginPage;
    private final LandingPage landingPage;
    private final CartPage cartPage;
    private HashMap<String, String> endpointData;
    Hooks localHooks;
    Response response;

    public FirstTestSteps(Hooks hooks) {
        localHooks = hooks;
        driver = localHooks.getDriver();
        endpointData = ApiSetup.getData();
        loginPage = new LoginPage(driver);
        landingPage = new LandingPage(driver);
        cartPage = new CartPage(driver);
    }

    @When("user navigates to portal")
    public void userNavigates() {
        loginPage.accessUrl();
    }

    @When("user enters username {string}")
    public void userEntersUserName(String userName) {
        loginPage.setUserName(userName);
    }

    @When("user enters password {string}")
    public void userEntersPassword(String password) {
        loginPage.setPassword(password);
    }

    @When("user clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("login is successful")
    public void loginIsSuccessful() {
        assertTrue(landingPage.isLoginSuccessful(), "Login not successful");
    }

    @Then("images page is loaded")
    public void imagesPageIsLoaded() {
        assertTrue(loginPage.isImagesPageLoaded());
    }

    @When("user adds {string} to cart")
    public void userAddsToCart(String productName) {
        landingPage.clickAddToCart(productName);
    }

    @Then("product {string} should be added to cart")
    public void productShouldBeAddedToCart(String productName) {
        assertTrue(cartPage.isProductAvailable(productName), "Product "+productName+" not available");
    }

    @When("user clicks on cart link")
    public void userClicksOnCartLink() {
        landingPage.clickCartLink();
    }

    @When("user clicks on checkout button")
    public void userClicksOnCheckoutButton() {
        cartPage.clickCheckout();
    }

    @When("user opens page in new tab")
    public void userOpensPageInNewTab() {
        cartPage.openInNewTab();
    }

}