package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.LocationsDataProvider;
import ge.tbc.testautomation.steps.LocationsSteps;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(description = "Validate location data in Locations")
@Epic("Locations")
@Feature("Branch/ATM search")
public class LocationsTest extends BaseTest {
    @BeforeClass
    public void initialize() {
        locationsSteps = new LocationsSteps(page);
    }

    @Test(priority = 1)
    @Story("Navigate to locations page")
    @Severity(SeverityLevel.CRITICAL)
    public void goToLocationsPage() {
        commonSteps
                .openMenu(isMobile)
                .clickOnLocationsLink();
    }

    @Test(priority = 2, dependsOnMethods = "goToLocationsPage",
            dataProvider = "locationAreas",
            dataProviderClass = LocationsDataProvider.class)
    @Story("Search by area and verify locations count")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyLocationsCount(String area) {
        locationsSteps
                .enterLocationArea(area)
                .countAvailableLocations()
                .verifyAreaLocationsCount();
    }
}
