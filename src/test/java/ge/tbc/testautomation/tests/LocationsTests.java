package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.steps.LocationsSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.data.Constants.AREA;

// TODO: don't forget zephyr scenario id here in @Test
public class LocationsTests extends BaseTest {
    @BeforeClass
    public void initialize() {
        locationsSteps = new LocationsSteps(page);
    }
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
