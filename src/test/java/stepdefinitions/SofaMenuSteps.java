package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.*;
import pages.SofaMenuPage;


public class SofaMenuSteps {

    SofaMenuPage page = new SofaMenuPage(DriverFactory.getDriver());

    @When("user hovers on sofa menu")
    public void hover() {
        page.printSofas();
    }

    @Then("sofa list is printed")
    public void done() {}
}