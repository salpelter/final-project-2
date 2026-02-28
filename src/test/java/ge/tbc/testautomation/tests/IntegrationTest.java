package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.models.response.PageResponse;
import ge.tbc.testautomation.steps.ConsumerLoansSteps;
import ge.tbc.testautomation.steps.PageApiSteps;
import ge.tbc.testautomation.util.ValidationHelper;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.data.Constants.*;

@Test(description = "Verify UI and API data matches")
@Epic("Consumer loans")
@Feature("UI and API data consistency")
public class IntegrationTest extends BaseTest {
    @BeforeClass
    public void initialize() {
        consumerLoansSteps = new ConsumerLoansSteps(page);
        pageApiSteps = new PageApiSteps();
    }

    @Test
    @Story("Validate that UI content matches API response")
    @Severity(SeverityLevel.BLOCKER)
    public void validateUiAndApiContentMatch() {
        // this specific page was chosen for the sake of simplicity
        page.navigate(HOME_PAGE_URL + LANGUAGE_PATH + CONSUMER_LOANS_PATH);

        pageApiSteps
                .retrievePage(CONSUMER_LOANS_PAGE_ID);

        consumerLoansSteps
                .retrievePageTitles()
                .retrievePageListItems();

        var response = pageApiSteps.response
                .assertThat()
                .statusCode(200)
                .extract().as(PageResponse.class);

        ValidationHelper.validateTitles(
                response.getSectionComponents(),
                consumerLoansSteps.titles
        );

        ValidationHelper.validateListItems(
                response.getSectionComponents(),
                consumerLoansSteps.listItems
        );
    }
}
