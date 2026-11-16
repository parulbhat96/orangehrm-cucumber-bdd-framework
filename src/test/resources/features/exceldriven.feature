@regression @excel
Feature: Add Employee using Excel data

  Background:
    Given the user is logged in as admin

  Scenario Outline: Add employee with data from Excel
    When the user opens the Add Employee page
    And the user adds an employee using Excel data row "<testId>"
    Then the employee is saved successfully

    Examples:
      | testId |
      | EMP01  |
      | EMP02  |