package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.steps.LocationsSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(description = "Verify nearby location can be found")
@Epic("Locations")
@Feature("Branch/ATM search")
public class NearbyLocationsTest extends BaseTest {
    @BeforeClass
    public void initialize() {
        locationsSteps = new LocationsSteps(page);
    }

    @Test(priority = 1)
    public void goToLocationsPage() {
        commonSteps
                .openMenu(isMobile)
                .clickOnLocationsPageLink();
    }

    @Test(priority = 2, dependsOnMethods = "goToLocationsPage")
    public void findNearbyLocation() {
        locationsSteps
                .scrollToMap()
                .verifyLocationDotPresence()
                .clickOnRandomVisibleMapMarker();
    }

    @Test(priority = 3, dependsOnMethods = "findNearbyLocation")
    public void verifyLocationHighlighted() {
        locationsSteps
                .verifyMarkerInfoHighlighted();
    }
}
