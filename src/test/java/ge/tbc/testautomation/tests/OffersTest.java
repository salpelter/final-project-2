package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.OffersDataProvider;
import ge.tbc.testautomation.steps.OfferSteps;
import ge.tbc.testautomation.steps.OffersSteps;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(description = "Verify offers can be viewed", groups = {"View offers (SCRUM-T29)"})
@Epic("Offers")
@Feature("Card offers")
public class OffersTest extends BaseTest {
    @BeforeClass
    public void initialize() {
        offersSteps = new OffersSteps(page);
        offerSteps = new OfferSteps(page);
    }

    @Test(priority = 1)
    @Story("Navigate to offers page")
    @Severity(SeverityLevel.CRITICAL)
    public void goToOffersPage() {
        commonSteps
                .openMenu(isMobile)
                .clickOnOffersLink();

        offersSteps
                .clickOnAllCardOffers();
    }

    @Test(priority = 2, dependsOnMethods = "goToOffersPage",
            dataProvider = "offerIndexes",
            dataProviderClass = OffersDataProvider.class)
    @Story("Filter offers by type")
    @Severity(SeverityLevel.NORMAL)
    public void filterByOfferType(int index) {
        offersSteps
                .clickOnOfferType(index);
    }

    @Test(priority = 3, dependsOnMethods = "filterByOfferType")
    @Story("Select a random offer")
    @Severity(SeverityLevel.NORMAL)
    public void pickOffer() {
        offersSteps
                .pickRandomOffer();
    }

    @Test(priority = 4, dependsOnMethods = "pickOffer")
    @Story("Verify offer details visibility")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyVisibility() {
        // the original scenario didn't have this step
        // i don't have access to zephyr anymore to modify it
        // but programmatically it is necessary to add one more
        // step here to verify the page at least shows up
        offerSteps
                .verifyOfferTitleVisibility();
    }
}
