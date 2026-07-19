package com.kanchansali.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthApiTest {

    @Test
    public void verifyBasicAuthentication() {

        Response response =
                RestAssured
                        .given()
                        .auth()
                        .basic("postman", "password")
                        .when()
                        .get("https://postman-echo.com/basic-auth");

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200);

        Assert.assertTrue(
                response.jsonPath().getBoolean("authenticated")
        );
    }

    @Test
    public void verifyInvalidBasicAuthentication() {

        Response response =
                RestAssured
                        .given()
                        .auth()
                        .basic("wronguser", "wrongpassword")
                        .when()
                        .get("https://postman-echo.com/basic-auth");

        Assert.assertEquals(response.getStatusCode(), 401);
    }
}