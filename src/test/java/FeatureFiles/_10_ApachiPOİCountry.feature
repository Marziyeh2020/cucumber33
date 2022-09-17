Feature: ApachiPOI country Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly
    And Navigate to country page

    Scenario: create  country from excel
      When user create country with apachiPOI

  Scenario:  delete country from excel
      Then user Delete Citizenship With ApachiPOI