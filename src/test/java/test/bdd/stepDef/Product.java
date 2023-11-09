package test.bdd.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import test.config.TestConfig;
import test.controller.ElementController;
import test.data.ValidUserData;
import test.helper.LoginHelper;
import test.pages.PageCreateProduct;
import test.pages.PageDashboard;
import test.pages.PageLogin;
import test.routes.PageRoute;
import test.config.DriverSetup;

public class Product extends DriverSetup {

    static TestConfig config = new TestConfig();

    // initiate objects for all elements from each pages
    static PageLogin pageLogin = new PageLogin();
    static PageDashboard pageDashboard = new PageDashboard();
    static PageCreateProduct pageCreateProduct = new PageCreateProduct();

    // initiate test data
    static ValidUserData validUserData = new ValidUserData();

    // initiate element controller
    static ElementController elementController = new ElementController(driver);

    // initiate page routes object
    static PageRoute pageRoute = new PageRoute(config.getBaseUrl());

    @Given("user is on Dashboard page")
    public void user_is_on_dashboard_page() {
        driver.get(config.getBaseUrl());
        LoginHelper.Login(elementController, pageLogin, validUserData);
        By txt_storeName = pageDashboard.getTxt_storeName();
        Assert.assertTrue(elementController.verifyElementDisplayed(txt_storeName));
    }
    @When("user access Create Product page")
    public void user_access_create_product_page() {
        driver.navigate().to(pageRoute.getCreateProductPageURL());
    }
    @Then("user verify Create Product page")
    public void user_verify_create_product_page() {
        Assert.assertTrue(elementController.verifyElementDisplayed(pageCreateProduct.getTxt_newProduct()));
        Assert.assertEquals(elementController.getPageRoute(), pageRoute.getCreateProductPageURL());
    }

}
