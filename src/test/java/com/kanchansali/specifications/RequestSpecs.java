package com.kanchansali.specifications;

import com.kanchansali.api.Endpoints;
import com.kanchansali.config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecs {

    private RequestSpecs() {
        // Prevent instantiation
    }

    public static RequestSpecification getRequestSpec() {

        return new RequestSpecBuilder()
                .setBaseUri(Endpoints.BASE_URL)
                .addHeader("x-api-key", ConfigReader.get("api.key"))
                .setContentType("application/json")
                .build();
    }
}