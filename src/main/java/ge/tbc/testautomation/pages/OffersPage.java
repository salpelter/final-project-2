package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class OffersPage {
    public Locator offerTypes;
    public Locator offerBlocks;
    public Locator allCardOffersLink;

    public OffersPage(Page page) {
        offerTypes = page.locator("//tbcx-pw-tab-menu/div/button");
        offerBlocks = page.locator("app-marketing-list div a");
        allCardOffersLink = page.locator("//tbcx-pw-media/following-sibling::div//tbcx-pw-button//a[contains(@href, '/ka/offers/all-offers')]");
    }
}
