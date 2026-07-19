package com.kanchansali.tests;

import com.kanchansali.api.ApiClient;
import com.kanchansali.api.Endpoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiTest {

    @Test
    public void getSingleUser() {

        ApiClient apiClient = new ApiClient();


        Response response =
                apiClient.get(Endpoints.USERS + "/2");

        System.out.println(response.asPrettyString());

        Assert.assertEquals(
                response.statusCode(),
                200);

    }

}