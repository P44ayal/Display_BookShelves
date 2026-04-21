Feature: Bookshelves

  @smoke
  Scenario: Verify first three bookshelves
    Given user is on Urban Ladder application
    When user searches bookshelves
    And user applies filters
    Then user prints first three products
