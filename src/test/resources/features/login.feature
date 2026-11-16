Feature: Login

  Scenario: Valid login
    Given the user is on the login page
    When the user logs in with username "Admin" and password "admin123"
    Then the dashboard is displayed

  Scenario: Invalid login
    Given the user is on the login page
    When the user logs in with username "Admin" and password "wrong123"
    Then the error message "Invalid credentials" is displayed