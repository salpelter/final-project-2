package ge.tbc.testautomation.tests;

import com.microsoft.playwright.*;
import ge.tbc.testautomation.steps.CommonSteps;
import ge.tbc.testautomation.steps.OffersSteps;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.List;

import static ge.tbc.testautomation.data.Constants.HOME_PAGE_URL;

public class BaseTest {
    Playwright playwright;
    Browser browser;
    Page page;

    protected CommonSteps commonSteps;
    protected OffersSteps offersSteps;

    protected boolean isMobile;

    @Parameters({"isMobile", "browserType"})
    @BeforeClass
    public void setUp(boolean isMobile, String browserType) {
        playwright = Playwright.create();

        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
        // chrome and firefox enforce minimum viewport size in headed execution mode
        // so to actually emulate viewport size below, tests needs to run in headless
        options.setHeadless(false); // TODO: comment out

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

        if (this.isMobile) {
            var context = browser.newContext(new Browser.NewContextOptions()
                    // Galaxy S20 Ultra
                    .setViewportSize(412, 915)
                    .setDeviceScaleFactor(2.625)
                    .setUserAgent("Mozilla/5.0 (Linux; Android 11; SM-G988B Build/RP1A.200720.012; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.105 Mobile Safari/537.36"));

            this.page = context.newPage();
        }
        else {
            var context = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(null)
            );

            this.page = context.newPage();
        }
        page.navigate(HOME_PAGE_URL);

        commonSteps = new CommonSteps(page);
        offersSteps = new OffersSteps(page);

        commonSteps
                .verifyDenyCookiesButtonVisibility()
                .clickOnDenyCookiesButton();
    }

    @AfterClass
    public void tearDown() {
        page.close();
        browser.close();
        playwright.close();
    }
}
