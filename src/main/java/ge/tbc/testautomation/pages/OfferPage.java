package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class OfferPage {
    public Locator offerTitle;

    public OfferPage(Page page) {
        offerTitle = page.locator("tbcx-pw-container")
                .getByRole(AriaRole.HEADING, new Locator.GetByRoleOptions()
                        .setLevel(2));
    }
}
