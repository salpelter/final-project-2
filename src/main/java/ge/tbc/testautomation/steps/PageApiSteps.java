package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.api.client.PageApi;
import ge.tbc.testautomation.data.models.PageResponse;

import static ge.tbc.testautomation.data.Constants.CONSUMER_LOANS_PAGE_ID;

public class PageApiSteps {
    private PageApi api = new PageApi();

    public PageResponse response;

    public PageApiSteps retrieveConsumerLoansPage() {
        this.response =
        api
            .getPage(CONSUMER_LOANS_PAGE_ID)
        .then()
            .extract()
            .as(PageResponse.class);

        return this;
    }
}
