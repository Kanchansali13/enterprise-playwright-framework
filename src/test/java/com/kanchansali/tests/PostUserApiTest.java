package com.kanchansali.tests;
import com.github.javafaker.Faker;

import com.kanchansali.api.ApiClient;
import com.kanchansali.api.Endpoints;
import com.kanchansali.models.User;
import com.kanchansali.models.UserResponse;
import com.kanchansali.specifications.ResponseSpecs;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostUserApiTest extends BaseApiTest {

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

        response.then()
                .spec(ResponseSpecs.createdResponse());


        UserResponse userResponse = response.as(UserResponse.class);

        Assert.assertEquals(userResponse.getName(), "Kanchan");
        Assert.assertEquals(userResponse.getJob(), "SDET");

        System.out.println(userResponse.getId());
        System.out.println(userResponse.getCreatedAt());
    }

}
