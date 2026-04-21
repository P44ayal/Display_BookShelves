package utilities;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Allure;

public class ScreenshotUtils {

    public static void captureScreenshot(WebDriver driver, String scenarioName) {

        if (driver == null) {
            return;
        }

        try {
            byte[] screenshot =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment(
                    scenarioName,
                    new ByteArrayInputStream(screenshot)
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}