package ge.tbc.testautomation.data;

import org.testng.annotations.DataProvider;

// wanted to do this dynamically, but that would
// require somehow injecting the page here, so
// i thought it's not the best idea
public class OffersDataProvider {
    @DataProvider(name = "offerIndexes")
    public Object[][] getOfferIndexes() {
        return new Object[][] {
                { 0 },
                { 1 },
                { 2 }
        };
    }
}
