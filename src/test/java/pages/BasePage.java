package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private By loader = By.cssSelector(".oxd-form-loader");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // OrangeHRM shows a loading overlay that blocks clicks, so wait for it to go away
    protected void waitForLoaderToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
    }

    protected void click(By locator) {
        waitForLoaderToDisappear();
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void type(By locator, String text) {
        waitForLoaderToDisappear();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
}