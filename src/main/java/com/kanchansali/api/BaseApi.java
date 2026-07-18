package com.kanchansali.api;

import com.kanchansali.config.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseApi {

    protected static final String BASE_URL = "https://reqres.in/api";

    protected RequestSpecification request() {
        return RestAssured
                .given()
                .header("x-api-key", ConfigReader.get("api.key"))
                .contentType("application/json");
    }

}
