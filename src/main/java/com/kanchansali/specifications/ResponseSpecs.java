package com.kanchansali.specifications;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

public class ResponseSpecs {

    public static ResponseSpecification successResponse() {

        return new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType("application/json; charset=utf-8")
                .build();
    }

    public static ResponseSpecification createdResponse() {

        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectContentType("application/json; charset=utf-8")
                .build();
    }

    public static ResponseSpecification deleteResponse() {

        return new ResponseSpecBuilder()
                .expectStatusCode(204)
                .build();
    }
}
