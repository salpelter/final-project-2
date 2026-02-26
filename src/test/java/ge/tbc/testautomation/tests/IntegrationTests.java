package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.util.ValidationHelper;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.data.Constants.*;

public class IntegrationTests extends BaseTest {
    @Test
    public void validateUiAndApiContentMatch() {
        // this specific page was chosen for the sake of simplicity
        page.navigate(HOME_PAGE_URL + LANGUAGE_PATH + CONSUMER_LOANS_PATH);

        pageApiSteps
                .retrieveConsumerLoansPage();

        consumerLoansSteps
                .retrievePageTitles()
                .retrievePageListItems();

        ValidationHelper.validateTitles(
                pageApiSteps.response.getSectionComponents(),
                consumerLoansSteps.titles
        );

        ValidationHelper.validateListItems(
                pageApiSteps.response.getSectionComponents(),
                consumerLoansSteps.listItems
        );
    }
}
