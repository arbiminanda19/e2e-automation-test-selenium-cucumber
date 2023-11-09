package test.config;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestConfig {

    private WebDriver driver;
    private String baseUrl = "https://kasirdemo.belajarqa.com";
    private int timeout = 10;

    // method to return initiated driver
    public WebDriver getDriver(String browser) {
        // initialize WebDriver based on the chosen browser
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver");
            driver = new FirefoxDriver();
        }
        return driver;
    }

    // method to return base URL
    public String getBaseUrl() {
        return baseUrl;
    }

    // method to return timeout
    public int getTimeout() {
        return timeout;
    }
}
