package pages;

import java.util.List;
import org.openqa.selenium.*;
import utilities.Log;
import org.apache.logging.log4j.Logger;

public class BookshelvesPage {

    WebDriver driver;
    private static final Logger log = Log.logger(BookshelvesPage.class);

    public BookshelvesPage(WebDriver driver) {
        this.driver = driver;
    }

    By search = By.id("searchInput");
    By names = By.xpath("//h3[contains(@class,'XxwSy')]");
    By prices = By.xpath("//div[contains(@class,'UYQNp')]");

    public void searchBookshelves() {
        log.info("************ TEST CASE 1: BOOKSHELVES ************");
        log.info("Searching for Bookshelves");
        driver.findElement(search).sendKeys("Bookshelves", Keys.ENTER);
    }

    public void applyFilters() {
        log.info("Applying filters: Storage Type = Open, Max Price = 15000");

        driver.findElement(By.id("productsContainer")).click();
        driver.findElement(By.xpath("//span[text()='Storage Type']")).click();
        driver.findElement(By.xpath("//div[text()='Open Storage']")).click();

        driver.findElement(By.xpath("//span[text()='Price']")).click();
        WebElement max = driver.findElement(
                By.xpath("//input[contains(@aria-label,'Maximum value')]"));
        max.clear();
        max.sendKeys("15000");

        driver.findElement(By.xpath("//span[text()='Apply Filter']")).click();
    }

    public void printFirstThree() {
        log.info("Printing first three bookshelf products");

        List<WebElement> n = driver.findElements(names);
        List<WebElement> p = driver.findElements(prices);

        for (int i = 0; i < 3; i++) {
            log.info("Product: {} | Price: {}", n.get(i).getText(), p.get(i).getText());
            System.out.println(n.get(i).getText()+" - "+p.get(i).getText());
        }
    }
}
