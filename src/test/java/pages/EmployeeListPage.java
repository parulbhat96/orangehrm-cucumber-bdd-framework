package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class EmployeeListPage extends BasePage {

    private By employeeNameInput =
            By.xpath("//label[text()='Employee Name']/parent::div/following-sibling::div//input");
    private By searchButton = By.cssSelector("button[type='submit']");
    private By resultRows = By.cssSelector(".oxd-table-body .oxd-table-card");

    public EmployeeListPage(WebDriver driver) {
        super(driver);
    }

    public void searchByName(String name) {
        type(employeeNameInput, name);
        click(searchButton);
    }

    // Keeps checking until a result row contains both names, or the wait times out
    public boolean isEmployeeListed(String firstName, String lastName) {
        try {
            return wait.ignoring(StaleElementReferenceException.class).until(d ->
                    d.findElements(resultRows).stream().anyMatch(row ->
                            row.getText().contains(firstName) && row.getText().contains(lastName)));
        } catch (TimeoutException e) {
            return false;
        }
    }
}