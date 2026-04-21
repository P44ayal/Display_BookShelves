package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.*;
import pages.BookshelvesPage;
import utilities.Log;
import org.apache.logging.log4j.Logger;

public class BookshelvesSteps {

    BookshelvesPage page = new BookshelvesPage(DriverFactory.getDriver());

   
    @When("user applies filters")
    public void user_applies_filters() {
        page = new BookshelvesPage(DriverFactory.getDriver());
        page.applyFilters();
    }
    @Then("user prints first three products")
    public void print() {
        page.printFirstThree();
    }
    private static final Logger log = Log.logger(BookshelvesSteps.class);

    @When("user searches bookshelves")
    public void search() {
        log.info("Step: user searches bookshelves");
        page.searchBookshelves();
    }

}