package com.kanchansali.api;

import com.kanchansali.models.User;
import com.kanchansali.specifications.RequestSpecs;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserApi {

    public static Response createUser(User user) {

        return RestAssured
                .given(RequestSpecs.getRequestSpec())
                .body(user)
                .when()
                .post(Endpoints.USERS);
    }
}