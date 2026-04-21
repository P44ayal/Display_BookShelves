package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.Log;
import org.apache.logging.log4j.Logger;

public class SofaMenuPage {

    WebDriver driver;
    private static final Logger log = Log.logger(SofaMenuPage.class);

    public SofaMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void printSofas() {
        log.info("************ TEST CASE 2: SOFA MENU ************");
        log.info("Hovering on Sofas & Recliners menu");

        WebElement sofaMenu =
                driver.findElement(By.xpath("//span[text()='Sofas & Recliners']"));
        new Actions(driver).moveToElement(sofaMenu).perform();

        List<WebElement> sofas =
                driver.findElements(By.xpath("//a[contains(@class,'njdyQ')]"));

        List<String> sofaNames = new ArrayList<>();
        for (WebElement sofa : sofas) {
            sofaNames.add(sofa.getText());
        }

        for (String name : sofaNames) {
            log.info("Sofa Category: {}", name);
            System.out.println(name);
        }
    }
}