package test.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.config.TestConfig;

public class ElementController {

    private WebDriver driver;
    private WebDriverWait wait;
    TestConfig config = new TestConfig();

    public ElementController(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, config.getTimeout());
    }

    private WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator) {
        waitForElement(locator).click();
    }

    public void typeText(By locator, String text) {
        WebElement inputField = waitForElement(locator);
        inputField.clear();
        inputField.sendKeys(text);
    }

    public String getText(By locator) {
        return waitForElement(locator).getText();
    }

    public Boolean verifyElementDisplayed(By locator) {
        return waitForElement(locator).isDisplayed();
    }

    public String getPageRoute() {
        return driver.getCurrentUrl();
    }

}
