@saucedemo
Feature: Sauce demo test

  @logintest
  Scenario: Login demo
    Given user navigates to portal
    When user enters username "standard_user"
    And user enters password "secret_sauce"
    And user clicks on login button
    Then login is successful
    When user adds "backpack" to cart
    And user clicks on cart link
    Then product "Sauce Labs Backpack" should be added to cart
    When user clicks on checkout button
    And user opens page in new tab

  @Api-test
  Scenario: Api Test
    Given User should be able to create weather station with valid weather details
    Given user should get success response for valid external id passed in earlier test case

