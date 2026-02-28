package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.OffersPage;
import io.qameta.allure.Step;

import java.util.Random;

public class OffersSteps {
    Page page;
    OffersPage offersPage;

    Random rand;

    public OffersSteps(Page page) {
        this.page = page;
        offersPage = new OffersPage(page);

        rand = new Random();
    }

    @Step("Click on the 'All Card Offers' link")
    public OffersSteps clickOnAllCardOffers() {
        offersPage.allCardOffersLink.click();

        return this;
    }

    @Step("Click on an offer type")
    public OffersSteps clickOnOfferType(int index) {
        offersPage.offerTypes.nth(index).click(new Locator.ClickOptions().setForce(true));

        return this;
    }

    @Step("Pick a random offer from the available offers")
    public OffersSteps pickRandomOffer() {
        offersPage.offerBlocks.first().hover();

        var offersCount = offersPage.offerBlocks.count();

        var offerCard = offersPage.offerBlocks
                .nth(rand.nextInt(offersCount));

        offerCard.click(new Locator.ClickOptions().setForce(true));

        return this;
    }
}
