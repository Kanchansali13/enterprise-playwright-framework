package com.kanchansali.api;

import com.kanchansali.models.User;
import com.kanchansali.specifications.RequestSpecs;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserApi {



    // Get all users
    public static Response getAllUsers() {

        return RestAssured
                .given()
                .spec(RequestSpecs.getRequestSpec())
                .when()
                .get("/users");
    }

    // Get user by ID
    public static Response getUser(int id) {

        return RestAssured
                .given()
                .spec(RequestSpecs.getRequestSpec())
                .when()
                .get("/users/" + id);
    }

    // Create user
    public static Response createUser(String token, User user) {

        return RestAssured
                .given()
                .spec(RequestSpecs.getRequestSpec())
                .header("Authorization", "Bearer " + token)
                .body(user)
                .when()
                .post("/auth/users/add");
    }

    // Update user (PUT)
    public static Response updateUser(String token, int id, User user) {

        return RestAssured
                .given()
                .spec(RequestSpecs.getRequestSpec())
                .header("Authorization", "Bearer " + token)
                .body(user)
                .when()
                .put("/users/" + id);
    }

    // Patch user
    public static Response patchUser(String token, int id, User user) {

        return RestAssured
                .given()
                .spec(RequestSpecs.getRequestSpec())
                .header("Authorization", "Bearer " + token)
                .body(user)
                .when()
                .patch("/users/" + id);
    }

    // Delete user
    public static Response deleteUser(String token, int id) {

        return RestAssured
                .given()
                .spec(RequestSpecs.getRequestSpec())
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("/users/" + id);
    }

    // Current logged in user
    public static Response getCurrentUser(String token) {

        return RestAssured
                .given()
                .spec(RequestSpecs.getRequestSpec())
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/auth/me");
    }
}