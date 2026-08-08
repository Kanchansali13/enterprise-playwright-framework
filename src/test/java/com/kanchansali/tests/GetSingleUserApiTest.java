package com.kanchansali.tests;

import com.kanchansali.api.UserApi;
import com.kanchansali.models.CurrentUserResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSingleUserApiTest extends BaseApiTest {

    @Test
    public void getSingleUser() {

        Response response = UserApi.getUser(2);

        response.then().statusCode(200);

        CurrentUserResponse user =
                response.as(CurrentUserResponse.class);

        Assert.assertEquals(user.getId(), 2);
        Assert.assertEquals(user.getFirstName(), "Michael");
        Assert.assertEquals(user.getLastName(), "Williams");
    }

    @Test
    public void getInvalidUser() {

        Response response = UserApi.getUser(99999);

        response.then()
                .statusCode(404);

        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Body: " + response.asPrettyString());
    }

    @Test
    public void getUserWithLargeId() {

        Response response = UserApi.getUser(999999);

        response.then().statusCode(404);
    }
}