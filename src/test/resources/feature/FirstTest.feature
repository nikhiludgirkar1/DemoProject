@firsttest
Feature: This is first test

  @firsttest-1
  Scenario: Searching with google
    When user navigates to google.com
    And user clicks on images
    Then images page is loaded
    Given User should be able to create weather station with valid weather details

