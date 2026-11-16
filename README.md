# OrangeHRM Cucumber BDD Automation Framework

BDD test automation framework for the OrangeHRM demo application, built with
Java, Selenium WebDriver, Cucumber and TestNG using the Page Object Model.

## Tech Stack
- Java 17, Maven
- Selenium WebDriver 4
- Cucumber (BDD) with TestNG runner
- Apache POI (Excel test data)

## Features
- Gherkin feature files with Background and Scenario Outline
- Page Object Model with a BasePage that handles explicit waits and the loading overlay
- Excel-driven scenarios using Apache POI
- Tags (@smoke, @regression) to run selected suites
- Config file for URL and credentials (overridable from the command line)
- Failure screenshots attached to the Cucumber HTML report
- Headless execution support

## Project Structure
```
src/test/java
  ├── driver/            DriverFactory
  ├── hooks/             Hooks (setup, teardown, failure screenshots)
  ├── pages/             BasePage, LoginPage, DashboardPage, PimPage,
  │                      AddEmployeePage, EmployeeListPage
  ├── stepdefinitions/   LoginSteps, EmployeeSteps
  ├── runners/           TestRunner
  └── utils/             ConfigReader, ExcelUtils
src/test/resources
  ├── features/          login, addemployee, searchemployee, exceldriven
  └── config.properties
testdata/                EmployeeData.xlsx
```

## Test Coverage
| Feature | Scenarios |
|---------|-----------|
| Login | Valid login, invalid credentials |
| Add Employee | Scenario Outline with two data sets |
| Search Employee | Add an employee, then find them in the list |
| Excel-driven | Add employees using rows from an Excel file |

## How to Run
Prerequisites: Java 17+, Maven, Chrome.

```
git clone https://github.com/parulbhat96/orangehrm-cucumber-bdd-framework.git
cd orangehrm-cucumber-bdd-framework
mvn clean test
```

Run only smoke tests, headless:
```
mvn clean test -Dheadless=true -Dcucumber.filter.tags="@smoke"
```

The HTML report is generated at `target/cucumber-report.html`.

## Report
![Cucumber report](screenshots/cucumber-report.png)

## Notes
- The tests run against the public OrangeHRM demo site, which can be slow or
  reset its data. For that reason, scenarios run sequentially.

## Future Improvements
- CI pipeline with GitHub Actions
- API layer for test data setup
- Allure reporting
- Docker and Selenium Grid
- Cross-browser runs