package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.models.response.PageNotFoundResponse;
import ge.tbc.testautomation.data.models.response.page.PageResponse;
import ge.tbc.testautomation.steps.PageApiSteps;
import ge.tbc.testautomation.util.ValidationHelper;
import io.qameta.allure.*;
import net.datafaker.Faker;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.data.Constants.CONSUMER_LOANS_PAGE_ID;

@Epic("Page API")
@Feature("Page retrieval")
public class ApiTests {
    private final PageApiSteps pageApiSteps;

    private final Faker faker;

    public ApiTests() {
        pageApiSteps = new PageApiSteps();

        faker = new Faker();
    }

    @Test
    @Story("Retrieve a valid page, validate 200 response and fields")
    @Severity(SeverityLevel.BLOCKER)
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
    @Story("Retrieve an invalid page, validate 404 response and fields")
    @Severity(SeverityLevel.CRITICAL)
    public void validateInvalidPathFields() {
        pageApiSteps
                // uuid is not the format of page ids so it will fail
                .retrievePage(faker.internet().uuid());

        var response = pageApiSteps.response
                .assertThat()
                .statusCode(404)
                .extract().as(PageNotFoundResponse.class);

        ValidationHelper.validatePageNotFoundResponseFieldsNonNull(response);
    }
}
