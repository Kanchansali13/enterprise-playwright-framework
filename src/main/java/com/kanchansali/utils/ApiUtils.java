package com.kanchansali.utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiUtils {

    private ApiUtils() {}

    public static Response get(RequestSpecification spec, String endpoint) {
        return spec
                .when()
                .get(endpoint);
    }

    public static Response post(RequestSpecification spec, String endpoint, Object body) {
        return spec
                .body(body)
                .when()
                .post(endpoint);
    }

    public static Response put(RequestSpecification spec, String endpoint, Object body) {
        return spec
                .body(body)
                .when()
                .put(endpoint);
    }

    public static Response patch(RequestSpecification spec, String endpoint, Object body) {
        return spec
                .body(body)
                .when()
                .patch(endpoint);
    }

    public static Response delete(RequestSpecification spec, String endpoint) {
        return spec
                .when()
                .delete(endpoint);
    }
}