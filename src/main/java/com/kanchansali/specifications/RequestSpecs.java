package com.kanchansali.specifications;

import com.kanchansali.api.Endpoints;
import com.kanchansali.config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class RequestSpecs {

    private RequestSpecs() {
    }

    public static RequestSpecification getRequestSpec() {

        return new RequestSpecBuilder()
                .setBaseUri(Endpoints.DUMMY_BASE)
                .addHeader("x-api-key", ConfigReader.get("api.key"))
                .setContentType("application/json")
                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
                .build();
    }

    public static RequestSpecification getAuthRequestSpec() {

        return new RequestSpecBuilder()
                .setBaseUri(Endpoints.AUTH_BASE)
                .setContentType("application/json")
                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
                .build();
    }
}