package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.*;
import pages.GiftCardPage;

public class GiftCardSteps {

    GiftCardPage giftCardPage;

    @When("user opens gift card page")
    public void user_opens_gift_card_page() {
        giftCardPage = new GiftCardPage(DriverFactory.getDriver());
        giftCardPage.openGiftAndEnterInvalidDetails();
    }

    @And("user enters invalid sender email")
    public void user_enters_invalid_sender_email() {
        // handled in page class
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        System.out.println("Gift card scenario completed");
    }
}