package com.kanchansali.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ValidatedUserSchemaTest {

    @Test
    public void validateUserSchema() {

        Response response =
                given()
                        .when()
                        .get("https://jsonplaceholder.typicode.com/users/1");

        response
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/user-schema.json"));
    }
}