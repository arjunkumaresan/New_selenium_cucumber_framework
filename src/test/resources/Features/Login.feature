Feature: Login functionality


  Scenario: login with valid credentials
    Given User navigates to login page
    When User enters valid email "arjunbe.kumaresan@gmail.com"
    And User has entered valid password "Mine@9506"
    And User click on login button
    Then User should get successfully logged in

  Scenario: login with invalid credentials
    Given User navigates to login page
    When User enters invalid email "arjunkumaresan@gmail.com"
    And User has entered invalid password "Mine@950601"
    And User click on login button
    Then User should get proper warning message regarding mismatch

  Scenario: login with valid email and invalid password
    Given User navigates to login page
    When User enters valid email "arjunbe.kumaresan@gmail.com"
    And User has entered invalid password "Mine@9506o1"
    And User click on login button
    Then User should get proper warning message regarding mismatch

  Scenario: login with invalid email and valid password
    Given User navigates to login page
    When User enters valid email "arjun@gmail.com"
    And User has entered invalid password "Mine@9506o1"
    And User click on login button
    Then User should get proper warning message regarding mismatch

  Scenario: login without providing details
    Given User navigates to login page
    When User don't enter email
    And User don't enter password
    And User click on login button
    Then User should get proper warning message regarding mismatch