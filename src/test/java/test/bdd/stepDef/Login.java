package test.bdd.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import test.config.DriverSetup;
import test.config.TestConfig;
import test.controller.ElementController;
import test.data.InvalidUserData;
import test.data.ValidUserData;
import test.pages.PageDashboard;
import test.pages.PageLogin;
import test.routes.PageRoute;

public class Login extends DriverSetup {

    TestConfig config = new TestConfig();

    // initiate objects for all elements from each pages
    PageLogin pageLogin = new PageLogin();
    PageDashboard pageDashboard = new PageDashboard();

    // initiate test data
    ValidUserData validUserData = new ValidUserData();
    InvalidUserData invalidUserData = new InvalidUserData();

    // initiate element controller
    ElementController elementController = new ElementController(driver);

    // initiate page routes object
    PageRoute pageRoute = new PageRoute(config.getBaseUrl());

    @Given("user is on Login page")
    public void user_is_on_login_page() {
        driver.get(config.getBaseUrl());
    }

    @When("user input valid email")
    public void user_input_valid_email() {
        elementController.typeText(pageLogin.getInput_email(), validUserData.getEmail());
    }

    @When("user input valid password")
    public void user_input_valid_password() {
        elementController.typeText(pageLogin.getInput_pass(), validUserData.getPassword());
    }

    @When("user click submit login")
    public void user_click_submit_login() {
        elementController.click(pageLogin.getBtn_submitLogin());
    }

    @Then("user verify success login result")
    public void user_verify_success_login_result() {
        By txt_storeName = pageDashboard.getTxt_storeName();
        Assert.assertTrue(elementController.verifyElementDisplayed(txt_storeName));
        Assert.assertEquals(elementController.getPageRoute(), pageRoute.getDashboardPageURL());
        Assert.assertEquals(elementController.getText(txt_storeName), validUserData.getStoreName());
    }

    @When("user input invalid email")
    public void user_input_invalid_email() {
        elementController.typeText(pageLogin.getInput_email(), invalidUserData.getEmail());
    }
    @When("user input invalid password")
    public void user_input_invalid_password() {
        elementController.typeText(pageLogin.getInput_pass(), invalidUserData.getPassword());
    }

    @Then("user verify failed login result")
    public void user_verify_failed_login_result() {
        Assert.assertTrue(elementController.verifyElementDisplayed(pageLogin.getAlert_wrongCred()));
    }
}
