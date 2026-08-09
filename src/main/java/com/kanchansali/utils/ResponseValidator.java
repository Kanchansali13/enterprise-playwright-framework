package com.kanchansali.utils;

import io.restassured.response.Response;
import org.testng.Assert;

public class ResponseValidator {

    private ResponseValidator() {
        // Utility class
    }

    public static void assertStatusCode(Response response, int expectedStatusCode) {
        Assert.assertEquals(
                response.statusCode(),
                expectedStatusCode,
                "Unexpected status code"
        );
    }

    public static void assertJsonResponse(Response response) {
        String contentType = response.getContentType();

        Assert.assertTrue(
                contentType != null && contentType.contains("application/json"),
                "Expected JSON response but received: " + contentType
        );
    }
}