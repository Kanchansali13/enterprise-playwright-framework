package com.kanchansali.tests;

import com.kanchansali.api.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ValidatedUserSchemaTest {

    @Test
    public void validateUserSchema() {

        Response response = RestAssured
                .given()
                .baseUri(Endpoints.JSONPLACEHOLDER_BASE)
                .when()
                .get(Endpoints.USERS + "/1");

        Assert.assertEquals(response.statusCode(), 200);

        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/jsonplaceholder-user-schema.json"));
    }
}