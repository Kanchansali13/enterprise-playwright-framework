package com.kanchansali.tests;

import com.kanchansali.api.ApiClient;
import com.kanchansali.api.Endpoints;
import com.kanchansali.utils.TokenManager;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiTest {

    @Test
    public void getSingleUser() {

        ApiClient apiClient = new ApiClient();

        String token = TokenManager.getToken();
        Response response =
                apiClient.get(Endpoints.USERS + "/2");

        System.out.println(response.asPrettyString());

        Assert.assertEquals(
                response.statusCode(),
                200);

    }

}