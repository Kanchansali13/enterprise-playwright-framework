package com.kanchansali.api;

import io.restassured.response.Response;
import io.restassured.RestAssured;

public class ApiClient {

    public Response get(String endpoint){

        return RestAssured.given().baseUri(Endpoints.BASE_URL).header("x-api-key", "free_user_3GftHBVXZzGTaQkUIOPKGpiedjr")
                .when()
                .get(endpoint);
    }

    public Response post(String endpoint, Object body) {

        return RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .contentType("application/json")
                .body(body)
                .when()
                .post(endpoint);
    }

    public Response put(String endpoint, Object body) {

        return RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .contentType("application/json")
                .body(body)
                .when()
                .put(endpoint);
    }

    public Response delete(String endpoint) {

        return RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .when()
                .delete(endpoint);
    }
}


