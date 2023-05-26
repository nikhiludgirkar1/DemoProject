@firsttest
Feature: This is first test

  @firsttest-1
  Scenario: Searching with google
    When user navigates to google.com
    And user clicks on images
    Then images page is loaded
    Given Admin should be able to create user with name "Neo" and job "Matrix"
    And user gets response for valid user id
