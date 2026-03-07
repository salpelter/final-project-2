package ge.tbc.testautomation.tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Geolocation;
import ge.tbc.testautomation.steps.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Arrays;
import java.util.List;

import static ge.tbc.testautomation.data.Constants.HOME_PAGE_URL;

public class BaseTest {
    Playwright playwright;
    Browser browser;
    Page page;

    protected CommonSteps commonSteps;
    protected OffersSteps offersSteps;
    protected OfferSteps offerSteps;
    protected LocationsSteps locationsSteps;
    protected ConsumerLoansSteps consumerLoansSteps;
    protected MoneyTransfersSteps moneyTransfersSteps;

    protected PageApiSteps pageApiSteps;

    protected boolean isMobile;
    @Parameters({"isMobile", "browserType"})
    @BeforeClass
    public void setUp(boolean isMobile, String browserType) {
        playwright = Playwright.create();

        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
        // chrome and firefox enforce minimum viewport size in headed execution mode
        // so to actually emulate viewport size below, tests needs to run in headless
        // also, in headed mode visual regression tests are affected because there's
        // an additional 15px of width allocated for the scrollbar
        // options.setHeadless(false);

        if (browserType.equalsIgnoreCase("chrome")) {
            browser = playwright.chromium().launch(options);
        }
        else if (browserType.equalsIgnoreCase("firefox")) {
            browser = playwright.firefox().launch(options);
        }
        else if (browserType.equalsIgnoreCase("webkit")) {
            browser = playwright.webkit().launch(options);
        }

        this.isMobile = isMobile;

        var contextOptions = new Browser.NewContextOptions()
                .setGeolocation(41.693408, 44.801498)
                .setPermissions(List.of("geolocation"));

        if (this.isMobile) {
            var context = browser.newContext(contextOptions
                    // iPhone 16 Plus
                    .setViewportSize(430, 932)
                    // backstopjs does not support scale factor
                    //.setDeviceScaleFactor(3)
                    .setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 18_7 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/18.7 Mobile/15E148 Safari/604.1"));

            this.page = context.newPage();
        }
        else {
            var context = browser.newContext(contextOptions
                    // page is being rendered inside a smaller physical window
                    // and playwright is forcing a larger css viewport inside it
                    // so explicitly setting a resolution offsets the page visually,
                    // although tests normally run without issues
                    .setViewportSize(1920, 1080)
            );

            this.page = context.newPage();
        }
        page.navigate(HOME_PAGE_URL);

        commonSteps = new CommonSteps(page);

        try {
            commonSteps
                    .verifyDenyCookiesButtonVisibility()
                    .clickOnDenyCookiesButton();
        }
        catch (TimeoutError e) {}
    }

    @AfterClass
    public void tearDown() {
        page.close();
        browser.close();
        playwright.close();
    }
}
