package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import ge.tbc.testautomation.db.DbConfig;
import ge.tbc.testautomation.pages.LocationsPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class LocationsSteps {
    Page page;
    LocationsPage locationsPage;

    int actualLocationsCount;
    String area;

    Random rand;

    public LocationsSteps(Page page) {
        this.page = page;
        locationsPage = new LocationsPage(page);

        rand = new Random();
    }

    @Step("Scroll to the locations map")
    public LocationsSteps scrollToMap() {
        locationsPage.map.evaluate(
                "el => el.scrollIntoView({block: 'center', behavior: 'instant'})"
        );

        return this;
    }

    @Step("Enter location area '{area}' in the search field")
    public LocationsSteps enterLocationArea(String area) {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        this.area = area;

        locationsPage.inputField.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));

        locationsPage.inputField.fill(area);
        page.waitForTimeout(1000);

        locationsPage.addresses.first().waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));

        return this;
    }

    @Step("Count the available locations in search results")
    public LocationsSteps countAvailableLocations() {
        locationsPage.addresses.first().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        this.actualLocationsCount = locationsPage.addresses.count();

        return this;
    }

    @Step("Verify locations count matches the expected count from DB")
    public LocationsSteps verifyAreaLocationsCount() {
        var mapper = DbConfig.getLocationsMapper();
        var expectedLocationsCount = mapper.getMinResultCountByArea(this.area);

        Assert.assertEquals(this.actualLocationsCount, expectedLocationsCount);
        return this;
    }

    @Step("Verify current location dot is present")
    public LocationsSteps verifyLocationDotPresence() {
        locationsPage.currentLocationDot.first().waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));

        // sometimes during loading hundreds of elements
        // match before actually matching the location dot
        page.waitForTimeout(3000);

        return this;
    }

    @Step("Click on a random nearby marker")
    public void clickOnRandomVisibleMapMarker() {
        // limited attempts to avoid using an infinite loop
        int attempts = 0;
        while (attempts++ < 10) {

            var visibleMarkers = getMarkersInViewport(locationsPage.mapMarkers);
            if (visibleMarkers.isEmpty()) {
                throw new IllegalStateException("No markers nearby. Try a different location.");
            }

            var marker = visibleMarkers.get(rand.nextInt(visibleMarkers.size()));
            marker.click(new Locator.ClickOptions().setForce(true));

            try {
                locationsPage.highlightedMarkerInfoBlock.waitFor(new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.VISIBLE));
                return;
            }
            catch (TimeoutError ignored) {
                // was a cluster or intercepted - loop picks a new marker
            }
        }

        throw new IllegalStateException("Couldn't select a non-clustered marker after 10 attempts.");
    }

    public LocationsSteps verifyMarkerInfoHighlighted() {
        Assert.assertTrue(locationsPage.highlightedMarkerInfoBlock.isVisible());

        return this;
    }

    public LocationsSteps clickOnCityDropdown() {
        locationsPage.cityDropdown.click();

        return this;
    }

    public LocationsSteps clickOnRandomCity() {
        locationsPage.cityDropdownOptions.first().waitFor(
                new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

        int citiesCount = locationsPage.cityDropdownOptions.count();

        var randomCity = locationsPage.cityDropdownOptions.nth(rand.nextInt(citiesCount));
        randomCity.scrollIntoViewIfNeeded();
        randomCity.click();

        return this;
    }

    public LocationsSteps clickOnBranchesFilter() {
        locationsPage.branchesFilter.waitFor(
                new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

        locationsPage.branchesFilter.click();

        return this;
    }

    public LocationsSteps clickOnOpenFilter() {
        locationsPage.openFilter.waitFor(
                new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

        locationsPage.openFilter.click();

        return this;
    }

    // helper method
    private List<Locator> getMarkersInViewport(Locator markers) {
        return markers.all().stream()
                .filter(marker -> Boolean.TRUE.equals(marker.evaluate(
                        """
                        el => {
                            const map = el.closest('.map-container') ?? el.closest('google-map > div');
                            if (!map) return false;
                            const panel = document.querySelector('.tbcx-pw-atm-branches-section__list-wrapper');
                            const mRect = map.getBoundingClientRect();
                            const pRect = panel ? panel.getBoundingClientRect() : { right: 0 };
                            const eRect = el.getBoundingClientRect();
                            return (
                                eRect.top >= mRect.top &&
                                eRect.bottom <= mRect.bottom &&
                                eRect.left >= pRect.right &&
                                eRect.right <= mRect.right
                            );
                        }
                        """
                )))
                .toList();
    }
}
