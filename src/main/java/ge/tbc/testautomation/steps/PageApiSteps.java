package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.api.client.PageApi;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class PageApiSteps {
    private PageApi api = new PageApi();

    public ValidatableResponse response;

    public PageApiSteps retrievePage(String pageId) {
        this.response =
        api
            .getPage(pageId)
        .then();

        return this;
    }
}
