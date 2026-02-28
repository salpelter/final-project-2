package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.steps.LocationsSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test(groups = {"Find an open branch in a city (SCRUM-T28)"})
@Epic("Locations")
@Feature("Branch/ATM search")
public class OpenBranchesTest extends BaseTest {
    @BeforeClass
    public void initialize() {
        locationsSteps = new LocationsSteps(page);
    }

    @Test(priority = 1)
    public void goToBranchesAndAtmsPage() {
        commonSteps
                .openMenu(isMobile)
                .clickOnLocationsPageLink();
    }

    @Test(priority = 2, dependsOnMethods = "goToBranchesAndAtmsPage")
    public void selectCity() {
        locationsSteps
                .clickOnCityDropdown()
                .clickOnRandomCity();
    }

    @Test(priority = 3, dependsOnMethods = "selectCity")
    public void filterByBranches() {
        locationsSteps
                .clickOnBranchesFilter();
    }

    @Parameters("isMobile")
    @Test(priority = 4, dependsOnMethods = "filterByBranches")
    public void filterByOpenBranches() {
        locationsSteps
                .scrollToMap()
                .clickOnOpenFilter();
    }

    @Test(priority = 5, dependsOnMethods = "filterByOpenBranches")
    public void selectBranch() {
        locationsSteps
                .clickOnRandomVisibleMapMarker();
    }

    @Test(priority = 6, dependsOnMethods = "selectBranch")
    public void verifyLocationHighlighted() {
        locationsSteps
                .verifyMarkerInfoHighlighted();
    }
}
