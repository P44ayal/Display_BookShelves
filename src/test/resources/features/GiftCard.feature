Feature: Gift Card

  @smoke
  Scenario: Verify gift card invalid email
    Given user is on Urban Ladder application
    When user opens gift card page
    And user enters invalid sender email
    Then error message should be displayed
