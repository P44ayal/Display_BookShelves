package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;
import utilities.Log;
import org.apache.logging.log4j.Logger;

public class BaseTest {

    protected WebDriver driver;
    protected static final Logger log = Log.logger(BaseTest.class);

    @BeforeMethod
    public void setUp() {
        log.info("TestNG setup: launching browser");
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        log.info("TestNG teardown: closing browser");
        DriverFactory.quitDriver();
    }
}
