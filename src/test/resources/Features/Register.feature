Feature: Registration functionality

  Scenario: User creates an account only with mandatory details
    Given User navigate to register page
    When User enters the details into below fields
      |firstname|arjun                     |
      |lastname |k                         |
      |email    |arjunkumaresan96@gmail.com|
      |telephone|9876543210                |
      |password |Mine@9506                 |
    And User selects privacy policy
    And User clicks on continue button

    Then User account shout get created successfully

  Scenario:User creates an account with all fields
    Given User navigate to register page
    When User enters the details into below fields
      |firstname|arjun                     |
      |lastname |k                         |
      |email    |arjunkumaresan98@gmail.com|
      |telephone|9876543210                |
      |password |Mine@9506                 |
    And User select yes for news letter
    And User selects privacy policy
    And User clicks on continue button
    Then User account shout get created successfully

   Scenario: User create a duplicate account
     Given User navigate to register page
     When User enters the details into below fields
       |firstname|arjunkumaresan            |
       |lastname |kp                        |
       |email    |arjunkumaresan98@gmail.com|
       |telephone|9876543201                |
       |password |Mine@9506                 |
     And User select yes for news letter
     And User selects privacy policy
     And User clicks on continue button
     Then User account shout get proper warning message about duplicate email

   Scenario: User create an account without providing any details
     Given User navigate to register page
     When User don't enter any details into fields
     And User clicks on continue button
     Then User should get proper warning message for every mandatory fields