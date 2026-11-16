package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    private WebDriverWait wait;

    private By header = By.cssSelector(".oxd-topbar-header-breadcrumb-module");

    public DashboardPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getHeaderText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(header)).getText();
    }
}