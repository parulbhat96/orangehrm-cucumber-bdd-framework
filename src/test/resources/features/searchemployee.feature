Feature: Search Employee

  Background:
    Given the user is logged in as admin

  @regression
  Scenario: Search for a newly added employee
    When the user opens the Add Employee page
    And the user adds an employee with first name "Neha" and last name "Singh"
    Then the employee is saved successfully
    When the user opens the Employee List page
    And the user searches for the employee "Neha Singh"
    Then the employee "Neha Singh" appears in the search results