Feature:search functionality

  Scenario: User search for a valid product
    Given User opens the application
    When User enters valid product "HP" into search box field
    And User click on search button
    Then User should get valid product displayed in the results

  Scenario: User search for a invalid product
    Given User opens the application
    When User enters valid product "Honda" into search box field
    And User click on search button
    Then User should get a message about no product matching

  Scenario: User search without any product
    Given User opens the application
    When User don't enter any product name into search box field
    And User click on search button
    Then User should get a message about no product matching

