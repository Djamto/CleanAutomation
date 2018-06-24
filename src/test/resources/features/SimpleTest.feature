Feature: SimpleTestFeature

  Scenario: Navigate through some pages
    Given The step for resetting the scenario data
    Given The step for setting the scenario dummy data
    When The user has opened the about page
    And The user has opened the legal page
    Then The user has validated the legal page is changed