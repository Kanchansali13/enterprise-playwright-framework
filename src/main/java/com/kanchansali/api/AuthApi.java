package com.kanchansali.api;

import com.kanchansali.models.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthApi {

    public static Response login(LoginRequest request) {

        return RestAssured
                .given()
                .contentType("application/json")
                .body(request)
                .post(Endpoints.LOGIN);
    }
}