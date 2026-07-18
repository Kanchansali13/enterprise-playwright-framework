package com.kanchansali.api;

import com.kanchansali.config.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiClient {

    public Response get(String endpoint) {

        return RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .header("x-api-key", ConfigReader.get("api.key"))
                .log().all()

                .when()
                .get(endpoint)

                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response post(String endpoint, Object body) {

        return RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .header("x-api-key", ConfigReader.get("api.key"))
                .contentType("application/json")
                .log().all()
                .body(body)

                .when()
                .post(endpoint)

                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response put(String endpoint, Object body) {

        return RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .header("x-api-key", ConfigReader.get("api.key"))
                .contentType("application/json")
                .log().all()
                .body(body)

                .when()
                .put(endpoint)

                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response delete(String endpoint) {

        return RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .header("x-api-key", ConfigReader.get("api.key"))
                .log().all()

                .when()
                .delete(endpoint)

                .then()
                .log().all()
                .extract()
                .response();
    }
}