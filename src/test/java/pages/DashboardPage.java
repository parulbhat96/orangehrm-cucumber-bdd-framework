package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private By header = By.cssSelector(".oxd-topbar-header-breadcrumb-module");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return getText(header);
    }
}