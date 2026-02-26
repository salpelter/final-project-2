package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.OffersDataProvider;
import org.testng.annotations.Test;

public class OffersTests extends BaseTest {
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
