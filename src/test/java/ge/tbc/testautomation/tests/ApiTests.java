package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.models.response.PageNotFoundResponse;
import ge.tbc.testautomation.data.models.response.PageResponse;
import ge.tbc.testautomation.steps.PageApiSteps;
import ge.tbc.testautomation.util.ValidationHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.data.Constants.CONSUMER_LOANS_PAGE_ID;

public class ApiTests {
    private final PageApiSteps pageApiSteps;

    public ApiTests() {
        pageApiSteps = new PageApiSteps();
    }

    @Test
    public void validateValidPathFields() {
        pageApiSteps
                .retrievePage(CONSUMER_LOANS_PAGE_ID);

        var response = pageApiSteps.response
                .assertThat()
                .statusCode(200)
                .extract().as(PageResponse.class);

        ValidationHelper.validatePageResponseFieldsNonNull(response);
    }

    @Test
    public void validateInvalidPathFields() {
        pageApiSteps
                .retrievePage("invalidPageId");

        var response = pageApiSteps.response
                .assertThat()
                .statusCode(404)
                .extract().as(PageNotFoundResponse.class);

        ValidationHelper.validatePageNotFoundResponseFieldsNonNull(response);
    }
}
