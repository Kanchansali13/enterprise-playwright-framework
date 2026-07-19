package com.kanchansali.tests;

import com.github.javafaker.Faker;
import com.kanchansali.api.ApiClient;
import com.kanchansali.api.Endpoints;
import com.kanchansali.models.User;
import com.kanchansali.specifications.RequestSpecs;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutUserApiTest {

    public Response put(String endpoint, Object body) {

        return RestAssured
                .given(RequestSpecs.getRequestSpec())
                .body(body)
                .when()
                .put(endpoint);
    }

//    @Test
//    public void updateUser() {
//
//        ApiClient apiClient = new ApiClient();
//
//        //User user = new User("Kanchan Updated","Senior SDET");
//
//        Faker faker = new Faker();
//
//        //User user = new User(faker.name().fullName(), faker.job().title());
//        String name = faker.name().fullName();
//        String job = faker.job().title();
//
//        User user = new User(name, job);
//
//
//
//        Response response =
//                apiClient.put(Endpoints.USERS + "/2", user);
//
//        response.prettyPrint();
//
//        Assert.assertEquals(response.statusCode(), 200);
//
//        Assert.assertEquals(response.jsonPath().getString("name"), name);
//        Assert.assertEquals(response.jsonPath().getString("job"), job);
//    }

    @Test(groups = {"regression", "api"})
    public void updateUser() {

    }
}
