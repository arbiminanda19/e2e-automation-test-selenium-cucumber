package test.scenarios;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import test.config.TestConfig;
import test.controller.ElementController;
import test.data.InvalidUserData;
import test.data.ValidUserData;
import test.pages.PageDashboard;
import test.pages.PageLogin;
import test.routes.PageRoute;

import java.util.concurrent.TimeUnit;

public class Login {

    // initiate object from TestObject using Chrome as browser
    static TestConfig config = new TestConfig();

    // setup driver using config object
    public static WebDriver driver = config.getDriver("chrome");

    // initiate objects for all elements from each pages
    PageLogin pageLogin = new PageLogin();
    PageDashboard pageDashboard = new PageDashboard();

    // initiate js_executor so can execute javascript
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

    // initiate test data
    ValidUserData validUserData = new ValidUserData();
    InvalidUserData invalidUserData = new InvalidUserData();

    // initiate element controller
    ElementController elementController = new ElementController(driver);

    // initiate page routes object
    PageRoute pageRoute = new PageRoute(config.getBaseUrl());

    @BeforeAll
    // for prepare test environment
    public static void setupDriver() {

        driver.manage().timeouts().implicitlyWait(config.getTimeout(), TimeUnit.SECONDS);

    }

    @BeforeEach
    public void accessLoginPage() {
        // access base url
        driver.get(config.getBaseUrl());
    }

    @Test
    public void successLogin() {

        // input credential for login
        elementController.typeText(pageLogin.getInput_email(), validUserData.getEmail());
        elementController.typeText(pageLogin.getInput_pass(), validUserData.getPassword());

        // click login
        elementController.click(pageLogin.getBtn_submitLogin());

        // assert login is success
        By txt_storeName = pageDashboard.getTxt_storeName();
        Assert.assertTrue(elementController.verifyElementDisplayed(txt_storeName));
        Assert.assertEquals(elementController.getPageRoute(), pageRoute.getDashboardPageURL());
        Assert.assertEquals(elementController.getText(txt_storeName), validUserData.getStoreName());

    }

    @Test
    public void failedLogin() {

        // input credential for login
        elementController.typeText(pageLogin.getInput_email(), invalidUserData.getEmail());
        elementController.typeText(pageLogin.getInput_pass(), invalidUserData.getPassword());

        // click login
        elementController.click(pageLogin.getBtn_submitLogin());

        // assert login id failed
        Assert.assertTrue(elementController.verifyElementDisplayed(pageLogin.getAlert_wrongCred()));

    }

    @AfterEach
    public void clearLocalStorage() {
        // Execute JavaScript to clear local storage
        jsExecutor.executeScript("window.localStorage.clear();");
    }

    @AfterAll
    // for close driver
    public static void tearDown() {
        driver.quit();
    }

}
