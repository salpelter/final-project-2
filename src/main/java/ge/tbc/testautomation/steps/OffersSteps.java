package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import ge.tbc.testautomation.pages.OffersPage;

import java.util.Random;

import static com.microsoft.playwright.options.WaitForSelectorState.VISIBLE;

public class OffersSteps {
    Page page;
    OffersPage offersPage;

    Random rand;

    public OffersSteps(Page page) {
        this.page = page;
        offersPage = new OffersPage(page);

        rand = new Random();
    }

    public OffersSteps clickOnAllCardOffers() {
        offersPage.allCardOffersLink.click();

        return this;
    }

    public OffersSteps clickOnOfferType(int index) {
        offersPage.offerTypes.nth(index).click();

        return this;
    }

    public OffersSteps pickRandomOffer() {
        offersPage.offerBlocks.nth(0).hover(); // make sure loaded

        var offersCount = offersPage.offerBlocks.count();

        var offerCard = offersPage.offerBlocks
                .nth(rand.nextInt(offersCount));

        offerCard.click(new Locator.ClickOptions().setForce(true));

        return this;
    }
}
