Feature: Test For google application

  Scenario: Verify Title of google page
    Given Browser should open app should launch
    When User captures Title of google page
    Then Excepted and Actual Title should match
