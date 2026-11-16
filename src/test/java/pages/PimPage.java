package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PimPage extends BasePage {

    private By pimMenu = By.xpath("//span[text()='PIM']");
    private By addEmployeeTab = By.xpath("//a[normalize-space()='Add Employee']");

    public PimPage(WebDriver driver) {
        super(driver);
    }

    public void openAddEmployee() {
        click(pimMenu);
        click(addEmployeeTab);
    }

    // Clicking PIM opens the Employee List by default
    public void openEmployeeList() {
        click(pimMenu);
    }
}