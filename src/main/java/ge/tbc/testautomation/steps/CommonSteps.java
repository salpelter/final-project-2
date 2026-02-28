package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.CommonPage;
import io.qameta.allure.Step;

public class CommonSteps {
    Page page;
    CommonPage commonPage;

    public CommonSteps(Page page) {
        this.page = page;
        commonPage = new CommonPage(page);
    }

    @Step("Open navigation menu")
    public CommonSteps openMenu(boolean isMobile) {
        if (isMobile) {
            commonPage.mobileHamburgerMenu.click();
        }
        else {
            commonPage.navPersonalTab.hover();
        }

        return this;
    }

    @Step("Click on the Offers link in the menu")
    public CommonSteps clickOnOffersLink() {
        commonPage.menuOffersLink.click();

        return this;
    }

    @Step("Verify that the deny cookies button is visible")
    public CommonSteps verifyDenyCookiesButtonVisibility() {
        commonPage.denyCookiesButton.isVisible();

        return this;
    }

    @Step("Click on the deny cookies button")
    public CommonSteps clickOnDenyCookiesButton() {
        commonPage.denyCookiesButton.click();

        return this;
    }

    @Step("Click on the Locations link")
    public CommonSteps clickOnLocationsLink() {
        commonPage.locationsLink.click();

        return this;
    }

    @Step("Unfold the Other Products section")
    public CommonSteps unfoldOtherProductsSection() {
        commonPage.otherProductsSection.click();

        return this;
    }

    @Step("Click on the Money Transfers page link")
    public CommonSteps clickOnMoneyTransfersPageLink() {
        commonPage.moneyTransfersLink.click();

        return this;
    }
}
