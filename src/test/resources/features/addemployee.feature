Feature: Add Employee

  Background:
    Given the user is logged in as admin

  Scenario Outline: Add a new employee
    When the user opens the Add Employee page
    And the user adds an employee with first name "<firstName>" and last name "<lastName>"
    Then the employee is saved successfully

    Examples:
      | firstName | lastName |
      | Anita     | Sharma   |
      | Rahul     | Verma    |