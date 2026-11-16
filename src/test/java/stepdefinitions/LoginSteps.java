package stepdefinitions;

import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginSteps {

    private LoginPage loginPage;

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        loginPage = new LoginPage(DriverFactory.getDriver());
    }

    @When("the user logs in with username {string} and password {string}")
    public void userLogsIn(String username, String password) {
        loginPage.login(username, password);
    }

    @Given("the user is logged in as admin")
    public void userIsLoggedInAsAdmin() {
        new LoginPage(DriverFactory.getDriver())
                .login(ConfigReader.get("adminUsername"), ConfigReader.get("adminPassword"));
        String header = new DashboardPage(DriverFactory.getDriver()).getHeaderText();
        Assert.assertEquals(header, "Dashboard");
    }
    @Then("the dashboard is displayed")
    public void dashboardIsDisplayed() {
        DashboardPage dashboardPage = new DashboardPage(DriverFactory.getDriver());
        Assert.assertEquals(dashboardPage.getHeaderText(), "Dashboard");
    }

    @Then("the error message {string} is displayed")
    public void errorIsDisplayed(String expected) {
        Assert.assertEquals(loginPage.getErrorMessage(), expected);
    }
}