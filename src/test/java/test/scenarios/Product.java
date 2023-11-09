package test.scenarios;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import test.config.TestConfig;
import test.controller.ElementController;
import test.data.ValidUserData;
import test.helper.LoginHelper;
import test.pages.PageCreateProduct;
import test.pages.PageDashboard;
import test.pages.PageLogin;
import test.routes.PageRoute;

import java.util.concurrent.TimeUnit;

public class Product {

    // initiate object from TestObject using Chrome as browser
    static TestConfig config = new TestConfig();

    // setup driver using config object
    public static WebDriver driver = config.getDriver("chrome");

    // initiate objects for all elements from each pages
    PageLogin pageLogin = new PageLogin();
    PageDashboard pageDashboard = new PageDashboard();
    PageCreateProduct pageCreateProduct = new PageCreateProduct();

    // initiate test data
    ValidUserData validUserData = new ValidUserData();

    // initiate element controller
    ElementController elementController = new ElementController(driver);

    // initiate page routes object
    PageRoute pageRoute = new PageRoute(config.getBaseUrl());

    @BeforeAll
    // for prepare test environment
    public static void setupDriver() {

        driver.manage().timeouts().implicitlyWait(config.getTimeout(), TimeUnit.SECONDS);
        driver.get(config.getBaseUrl());

    }

    @BeforeEach
    public void beforeEach() {
        LoginHelper.Login(elementController, pageLogin, validUserData);
    }

    @Test
    public void navigateToCreateProductPage() {

        // precondition: verify has on dashboard
        By txt_storeName = pageDashboard.getTxt_storeName();
        Assert.assertTrue(elementController.verifyElementDisplayed(txt_storeName));

        // navigate to access product page
        driver.navigate().to(pageRoute.getCreateProductPageURL());

        // assert
        Assert.assertTrue(elementController.verifyElementDisplayed(pageCreateProduct.getTxt_newProduct()));
        Assert.assertEquals(elementController.getPageRoute(), pageRoute.getCreateProductPageURL());

    }

    @AfterAll
    // for close driver
    public static void tearDown() {
        driver.quit();
    }

}
