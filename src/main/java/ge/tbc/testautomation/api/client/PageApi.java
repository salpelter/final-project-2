package ge.tbc.testautomation.api.client;

import io.restassured.response.Response;

import static ge.tbc.testautomation.data.Constants.QUERY_STRING_LOCALE_GE;
import static ge.tbc.testautomation.data.Constants.SITE_PAGE_PATH;
import static io.restassured.RestAssured.given;

public class PageApi extends BaseApi {
    public Response getPage(String pageId) {
        return
        given()
                .spec(SPEC)
        .when()
                .get(SITE_PAGE_PATH + "/" + pageId + QUERY_STRING_LOCALE_GE);
    }
}
