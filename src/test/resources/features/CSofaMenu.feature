Feature: Sofa Menu

  @smoke
  Scenario: Print sofa categories
    Given user is on Urban Ladder application
    When user hovers on sofa menu
    Then sofa list is printed
