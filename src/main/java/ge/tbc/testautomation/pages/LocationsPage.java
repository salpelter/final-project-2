package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LocationsPage {
    public Locator addresses;
    public Locator inputField;
    public Locator map;
    public Locator currentLocationDot;
    public Locator mapMarkers;
    public Locator highlightedMarkerInfoBlock;

    public Locator cityDropdown;
    public Locator cityDropdownOptions;
    public Locator branchesFilter;
    public Locator openFilter;

    public LocationsPage(Page page) {
        addresses = page.locator("app-atm-branches-section-list-item");
        inputField = page.getByPlaceholder("მიუთითე სასურველი ლოკაცია");

        // there were issues with locating the map sometimes so i used the xpath from final-project-1
        map = page.locator("//google-map/div[@class='map-container']/div");

        // this element is under a shadow root and it's difficult to locate it
        // so i used an old xpath
        currentLocationDot = page.locator("//gmp-advanced-marker[@position][not(@role)]");

        // again, there's not much uniqueness to these elements
        // so i had to use an old xpath again, but if there are
        // any playwright methods that can be used here,
        // please let me know because i couldn't apply any of them
        mapMarkers = page.locator("//gmp-advanced-marker[contains(@slot, 'internal-visible-gmp-advanced-markers')]");
        highlightedMarkerInfoBlock = page.locator("//app-atm-branches-section-list-item/div[contains(@class, 'active')]");

        cityDropdown = page.locator("tbcx-dropdown-selector", new Page.LocatorOptions().setHasText("აირჩიე ქალაქი"))
                .filter(new Locator.FilterOptions().setVisible(true));

        cityDropdownOptions = page.locator("//tbcx-dropdown-popover-item");
        branchesFilter = page.getByRole(AriaRole.BUTTON).getByText("ფილიალები");
        openFilter = page.locator("tbcx-pw-chip").getByText("ღიაა");
    }
}
