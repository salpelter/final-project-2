package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import ge.tbc.testautomation.db.DbConfig;
import ge.tbc.testautomation.pages.LocationsPage;
import org.testng.Assert;

public class LocationsSteps {
    Page page;
    LocationsPage locationsPage;

    int actualLocationsCount;
    String area;

    public LocationsSteps(Page page) {
        this.page = page;
        locationsPage = new LocationsPage(page);
    }

    public LocationsSteps enterLocationArea(String area) {
        this.area = area;

        locationsPage.inputField.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

        locationsPage.inputField.fill(area);
        page.waitForTimeout(1000);

        locationsPage.addresses.first().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

        return this;
    }

    public LocationsSteps countAvailableLocations() {
        locationsPage.addresses.first().hover();
        this.actualLocationsCount = locationsPage.addresses.count();

        return this;
    }

    public LocationsSteps verifyAreaLocationsCount() {
        var mapper = DbConfig.getLocationsMapper();
        var expectedLocationsCount = mapper.getMinResultCountByArea(this.area);

        Assert.assertEquals(this.actualLocationsCount, expectedLocationsCount);
        return this;
    }
}
