package pages;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utilities.ConfigReader;
import utilities.ExcelUtils;
import utilities.Log;
import org.apache.logging.log4j.Logger;

public class GiftCardPage {

    WebDriver driver;
    private static final Logger log = Log.logger(GiftCardPage.class);

    public GiftCardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openGiftAndEnterInvalidDetails() {

        log.info("************ TEST CASE 3: GIFT CARD ************");
        log.info("Loading test data from Excel");

        ExcelUtils.loadExcel(
                ConfigReader.getProperty("excelPath"),
                ConfigReader.getProperty("excelSheet")
        );

        String firstName = ExcelUtils.getData(1, 0);
        String lastName  = ExcelUtils.getData(1, 1);
        String email     = ExcelUtils.getData(1, 2);

        String parentWindow = driver.getWindowHandle();
        log.info("Clicking Gift Card link");
        driver.findElement(By.partialLinkText("Gift")).click();
        
        Set<String> allwindows=driver.getWindowHandles();
        for (String window : allwindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        log.info("Gift Card URL: {}", driver.getCurrentUrl());
        log.info("Gift Card Title: {}", driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement fname =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));

        fname.sendKeys(firstName);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.id("telephone")).sendKeys("9870347808");

        WebElement error =
                driver.findElement(By.xpath("//div[contains(@class,'invalid-address')]"));

        log.error("Validation Error Message: {}", error.getText());
        System.out.println("ERROR MESSAGE: "+error.getText());
    }
}
