package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.CommonPage;

public class CommonSteps {
    Page page;
    CommonPage commonPage;

    public CommonSteps(Page page) {
        this.page = page;
        commonPage = new CommonPage(page);
    }

    public CommonSteps openMenu(boolean isMobile) {
        if (isMobile) {
            commonPage.mobileHamburgerMenu.click();
        }
        else {
            commonPage.navPersonalTab.hover();
        }

        return this;
    }

    public CommonSteps clickOnOffersLink() {
        commonPage.menuOffersLink.click();

        return this;
    }

    public CommonSteps verifyDenyCookiesButtonVisibility() {
        commonPage.denyCookiesButton.isVisible();

        return this;
    }

    public CommonSteps clickOnDenyCookiesButton() {
        commonPage.denyCookiesButton.click();

        return this;
    }

    public CommonSteps clickOnLocationsLink() {
        commonPage.locationsLink.click();

        return this;
    }
}
