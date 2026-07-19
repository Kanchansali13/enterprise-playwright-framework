package com.kanchansali.tests;

import com.kanchansali.api.UserApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSingleUserApiTest extends BaseApiTest {

    @Test
    public void getSingleUser() {

        Response response =
                UserApi.getUser(2);

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200);

        Assert.assertEquals(
                response.jsonPath().getInt("data.id"),
                2);

        Assert.assertEquals(
                response.jsonPath().getString("data.first_name"),
                "Janet");
    }

    @Test
    public void getInvalidUser() {

        Response response =
                UserApi.getUser(23);

        Assert.assertEquals(response.getStatusCode(), 404);
    }
}