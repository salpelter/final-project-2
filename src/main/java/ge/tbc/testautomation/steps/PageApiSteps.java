package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.api.client.PageApi;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

public class PageApiSteps {
    private PageApi api = new PageApi();

    public ValidatableResponse response;

    @Step("Retrieve page data via API for pageId '{pageId}'")
    public PageApiSteps retrievePage(String pageId) {
        this.response =
        api
            .getPage(pageId)
        .then();

        return this;
    }
}
