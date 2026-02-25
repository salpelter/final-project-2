package ge.tbc.testautomation.tests;

import org.testng.annotations.Test;

import static ge.tbc.testautomation.data.Constants.AREA;

public class LocationsTest extends BaseTest {
    @Test(priority = 1)
    public void goToLocationsPage() {
        commonSteps
                .openMenu(isMobile)
                .clickOnLocationsLink();
    }

    @Test(priority = 2, dependsOnMethods = "goToLocationsPage")
    public void verifyLocationsCount() {
        locationsSteps
                .enterLocationArea(AREA)
                .countAvailableLocations()
                .verifyAreaLocationsCount();
    }
}
