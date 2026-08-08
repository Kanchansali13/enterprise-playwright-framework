package com.kanchansali.api;

import com.kanchansali.models.LoginRequest;
import com.kanchansali.specifications.RequestSpecs;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthApi {

    public static Response login(LoginRequest request) {

        return RestAssured
                .given()
                .spec(RequestSpecs.getAuthRequestSpec())
                .body(request)
                .when()
                .post(Endpoints.LOGIN);
    }
}