package com.kanchansali.tests;
import com.github.javafaker.Faker;

import com.kanchansali.api.ApiClient;
import com.kanchansali.api.Endpoints;
import com.kanchansali.models.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostUserApiTest {

    Faker faker=new Faker();

    User user = new User(
            faker.name().firstName(),
            "Automation Engineer");


    @Test
    public void createUser() {

        ApiClient apiClient = new ApiClient();

        User user = new User("Kanchan", "SDET");

        Response response = apiClient.post(Endpoints.USERS, user);

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 201);


        Assert.assertEquals(response.jsonPath().getString("name"), "Kanchan");

        Assert.assertEquals(response.jsonPath().getString("job"), "SDET");
    }

}
