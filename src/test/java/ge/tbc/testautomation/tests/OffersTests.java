package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.OffersDataProvider;
import ge.tbc.testautomation.steps.OffersSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = {"View offers (SCRUM-T29)"})
public class OffersTests extends BaseTest {
    @BeforeClass
    public void initialize() {
        offersSteps = new OffersSteps(page);
    }

    @Test(priority = 1)
    public void goToOffersPage() {
        commonSteps
                .openMenu(isMobile)
                .clickOnOffersLink();

        offersSteps
                .clickOnAllCardOffers();
    }

    @Test(priority = 2, dataProvider = "offerIndexes",
            dataProviderClass = OffersDataProvider.class, dependsOnMethods = "goToOffersPage")
    public void filterByOfferType(int index) {
        offersSteps
                .clickOnOfferType(index);
    }

    @Test(priority = 3, dependsOnMethods = "filterByOfferType")
    public void pickOffer() {
        offersSteps
                .pickRandomOffer();
    }
}
