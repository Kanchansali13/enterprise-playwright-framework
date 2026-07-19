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



    public static Response updateUser(int id, User user) {

        return RestAssured
                .given(RequestSpecs.getRequestSpec())
                .body(user)
                .when()
                .put(Endpoints.USERS + "/" + id);
    }

    public static Response patchUser(int id, User user) {

        return RestAssured
                .given()
                .spec(RequestSpecs.getRequestSpec())
                .body(user)
                .when()
                .patch(Endpoints.USERS + "/" + id);
    }

    public static Response deleteUser(int id) {

        return RestAssured
                .given(RequestSpecs.getRequestSpec())
                .when()
                .delete(Endpoints.USERS + "/" + id);
    }

    public static Response getUser(int id) {

        return RestAssured
                .given()
                .spec(RequestSpecs.getRequestSpec())
                .when()
                .get(Endpoints.USERS + "/" + id);
    }
}