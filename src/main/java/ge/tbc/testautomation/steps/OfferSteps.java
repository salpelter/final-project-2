package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import ge.tbc.testautomation.pages.OfferPage;
import io.qameta.allure.Step;

public class OfferSteps {
    Page page;
    OfferPage offerPage;

    public OfferSteps(Page page) {
        this.page = page;
        offerPage = new OfferPage(page);
    }

    @Step("Verify that the offer title is visible")
    public OfferSteps verifyOfferTitleVisibility() {
        offerPage.offerTitle.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

        return this;
    }
}
