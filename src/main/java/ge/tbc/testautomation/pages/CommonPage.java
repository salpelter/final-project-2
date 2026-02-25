package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CommonPage {
    public Locator navPersonalTab;
    public Locator menuOffersLink;
    public Locator locationsLink;

    public Locator mobileHamburgerMenu;
    public Locator denyCookiesButton;

    // there are several elements matching some locators,
    // but only one is visible at a time
    public CommonPage(Page page) {
        navPersonalTab = page.locator(".tbcx-pw-navigation-item",
                new Page.LocatorOptions().setHasText("ჩემთვის"))
                .filter(new Locator.FilterOptions().setVisible(true));

        menuOffersLink = page.locator(".tbcx-pw-mega-menu-quick-acitons-item",
                        new Page.LocatorOptions().setHasText("შეთავაზებები"))
                .filter(new Locator.FilterOptions().setVisible(true));

        locationsLink = page.locator(".tbcx-pw-mega-menu-quick-acitons-item",
                        new Page.LocatorOptions().setHasText("მისამართები"))
                .filter(new Locator.FilterOptions().setVisible(true));

        mobileHamburgerMenu = page.locator(".tbcx-pw-hamburger-menu")
                .filter(new Locator.FilterOptions().setVisible(true));

        denyCookiesButton = page.locator("//app-cookie-consent//button",
                new Page.LocatorOptions().setHasText("უარყოფა"));
    }
}
