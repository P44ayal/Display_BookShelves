package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import listeners.TestFailureListener;
import pages.BookshelvesPage;
import pages.GiftCardPage;
import pages.SofaMenuPage;



@Listeners(
    TestFailureListener.class
)

public class UrbanLadderTestNGTest extends BaseTest {
@Test(priority =1)
    public void verifyBookshelves() {
        BookshelvesPage page = new BookshelvesPage(driver);
        page.searchBookshelves();
       page.applyFilters();
        page.printFirstThree();
   }

//@Test(priority = 1)
//public void verifyBookshelves() {
//    Assert.fail("Intentional failure to test retry logic");
//}

    @Test(priority = 2)
    public void verifySofaMenu() {
        SofaMenuPage sofa = new SofaMenuPage(driver);
        sofa.printSofas();
    }

    @Test(priority = 3)
    public void verifyGiftCard() {
        GiftCardPage gift = new GiftCardPage(driver);
        gift.openGiftAndEnterInvalidDetails();
    }
}
