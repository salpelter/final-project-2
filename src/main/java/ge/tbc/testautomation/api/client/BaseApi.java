package ge.tbc.testautomation.api.client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static ge.tbc.testautomation.data.Constants.API_VERSION;
import static ge.tbc.testautomation.data.Constants.BASE_API_URL;

public class BaseApi {
    public static final RequestSpecification SPEC = new RequestSpecBuilder()
            .setBaseUri(BASE_API_URL)
            .setBasePath(API_VERSION)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build()

            .filters(new ResponseLoggingFilter());
}