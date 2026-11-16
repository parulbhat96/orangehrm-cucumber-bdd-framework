package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeePage extends BasePage {

    private By firstNameField = By.name("firstName");
    private By lastNameField = By.name("lastName");
    private By saveButton = By.cssSelector("button[type='submit']");
    private By toastMessage = By.cssSelector(".oxd-text--toast-message");

    public AddEmployeePage(WebDriver driver) {
        super(driver);
    }

    public void addEmployee(String firstName, String lastName) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        click(saveButton);
    }

    public String getSuccessMessage() {
        return getText(toastMessage);
    }
}