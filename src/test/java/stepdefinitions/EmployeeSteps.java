package stepdefinitions;

import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddEmployeePage;
import pages.EmployeeListPage;
import pages.PimPage;

public class EmployeeSteps {

    @When("the user opens the Add Employee page")
    public void openAddEmployeePage() {
        new PimPage(DriverFactory.getDriver()).openAddEmployee();
    }

    @When("the user adds an employee with first name {string} and last name {string}")
    public void addEmployee(String firstName, String lastName) {
        new AddEmployeePage(DriverFactory.getDriver()).addEmployee(firstName, lastName);
    }

    @Then("the employee is saved successfully")
    public void employeeSavedSuccessfully() {
        String message = new AddEmployeePage(DriverFactory.getDriver()).getSuccessMessage();
        Assert.assertTrue(message.contains("Successfully Saved"), "Actual message: " + message);
    }

    @When("the user opens the Employee List page")
    public void openEmployeeListPage() {
        new PimPage(DriverFactory.getDriver()).openEmployeeList();
    }

    @When("the user searches for the employee {string}")
    public void searchForEmployee(String fullName) {
        new EmployeeListPage(DriverFactory.getDriver()).searchByName(fullName);
    }

    @Then("the employee {string} appears in the search results")
    public void employeeAppearsInResults(String fullName) {
        String[] parts = fullName.split(" ");
        boolean found = new EmployeeListPage(DriverFactory.getDriver())
                .isEmployeeListed(parts[0], parts[1]);
        Assert.assertTrue(found, fullName + " was not found in the results");
    }
}