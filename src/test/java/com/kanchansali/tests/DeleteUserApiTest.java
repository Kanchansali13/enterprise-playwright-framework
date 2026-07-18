package com.kanchansali.tests;

import com.kanchansali.config.ConfigReader;
import com.kanchansali.specifications.ResponseSpecs;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserApiTest {

    @Test
    public void deleteUser() {

        Response response = RestAssured
                .given()
                .header("x-api-key", ConfigReader.get("api.key"))
                .when()
                .delete("https://reqres.in/api/users/2");

        response.then()
                .spec(ResponseSpecs.deleteResponse());
    }
}
