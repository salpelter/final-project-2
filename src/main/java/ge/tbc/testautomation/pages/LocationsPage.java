package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LocationsPage {
    public Locator addresses;
    public Locator inputField;

    public LocationsPage(Page page) {
        addresses = page.locator("app-atm-branches-section-list-item");
        inputField = page.getByPlaceholder("მიუთითე სასურველი ლოკაცია");
    }
}
