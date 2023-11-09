package test.bdd.stepDef;

import io.cucumber.java.*;
import test.config.DriverSetup;
import test.config.TestConfig;

import java.util.concurrent.TimeUnit;

// extends initiated driver on DriverSetup
public class Hooks extends DriverSetup {

    // initiate test config object
    TestConfig config = new TestConfig();

    @Before
    public void beforeEach(Scenario scenario) {
        // setup driver using config object
        driver = config.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(config.getTimeout(), TimeUnit.SECONDS);

        // log execute scenario start
        System.out.println("Run scenario " + scenario.getName());
    }

    @After
    public void afterEach(Scenario scenario) {
        System.out.println("Scenario " + scenario.getName() + " Executed");
        driver.quit();
    }

}
