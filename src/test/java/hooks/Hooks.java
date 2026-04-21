package hooks;

import base.BaseTest;
import base.DriverFactory;
import io.cucumber.java.*;
import utilities.ScreenshotUtils;
import utilities.Log;
import org.apache.logging.log4j.Logger;

public class Hooks extends BaseTest {

    private static final Logger log = Log.logger(Hooks.class);

    @Before
    public void beforeScenario(Scenario scenario) {
        log.info("===== STARTING SCENARIO: {} =====", scenario.getName());
        setUp();
    }

    @After
    public void afterScenario(Scenario scenario) {

        if (scenario.isFailed()) {
            log.error("Scenario FAILED: {}", scenario.getName());
            ScreenshotUtils.captureScreenshot(
                    DriverFactory.getDriver(),
                    scenario.getName()
            );
        } else {
            log.info("Scenario PASSED: {}", scenario.getName());
        }

        tearDown();
        log.info("===== SCENARIO FINISHED =====");
    }
}
