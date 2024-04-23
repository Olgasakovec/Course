Feature: UserGuide automation

  Scenario: Check the User Guide button text
    Given Open browser and maximize window
    When Navigate to the 'https://junit.org/junit5/' url
    Then Verify that User Guide button text is 'User Guide'
    
Feature: TestNG Documentation

  Scenario: Check TestNG Annotations columns
    Given Navigate to the page 'https://testng.org/' url
    When Maximize window
    And Click to the link '3. TestNG Documentation'
    And Navigate to the menu '3.2. Annotations'
    Then Check that table consist 3 columns
