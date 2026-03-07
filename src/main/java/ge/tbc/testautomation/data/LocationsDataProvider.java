package ge.tbc.testautomation.data;

import org.testng.annotations.DataProvider;

public class LocationsDataProvider {
    @DataProvider(name = "locationAreas")
    public Object[][] getLocationAreas() {
        return new Object[][] {
                { "რუსთაველის გამზ." },
                { "პეკინის გამზ." },
                { "ვაჟა-ფშაველას გამზ." }
        };
    }
}
