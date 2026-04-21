package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.BookshelvesPage;

import utilities.Log;
import org.apache.logging.log4j.Logger;


public class CommonSteps {

    BookshelvesPage bookshelvesPage;

private static final Logger log = Log.logger(CommonSteps.class);


@Given("user is on Urban Ladder application")
public void user_is_on_urban_ladder_application() {
    log.info("User is on Urban Ladder application");
}



}