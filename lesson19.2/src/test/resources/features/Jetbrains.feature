Feature: Variant 3

  Scenario: Check the Download button is available in menu Writerside
    Given Navigate to the 'https://www.jetbrains.com/' url
    When Click to the menu 'Developer Tools'
    And Choose 'Writerside' and click
    Then Verify that 'SDK docs' button text is displayed

  Scenario:   Check the Writerside tittle
    Given Navigate to the 'https://www.jetbrains.com/' url
    When Click to the menu 'Developer Tools'
    And Choose 'Writerside' and click
    And Turn on the 'Play' button
    Then Verify that 'Getting Started With Writerside' tittle is displayed

  Scenario: Check PyCharm
    Given Navigate to the 'https://www.jetbrains.com/' url
    When Click to the menu 'Developer Tools'
    And Choose 'PyCharm' and click
    Then Verify that 'Download' tittle is displayed