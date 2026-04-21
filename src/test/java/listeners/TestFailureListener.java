package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.Logger;
import utilities.Log;

public class TestFailureListener implements ITestListener {

    private static final Logger log = Log.logger(TestFailureListener.class);

    @Override
    public void onTestFailure(ITestResult result) {

        log.error("❌ TEST FAILED: {}", result.getName());

        if (result.getThrowable() != null) {
            log.error("❌ FAILURE REASON:", result.getThrowable());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("✅ TEST PASSED: {}", result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("⚠️ TEST SKIPPED: {}", result.getName());
    }
}