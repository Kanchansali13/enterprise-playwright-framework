package com.kanchansali.tests;

import com.kanchansali.api.ApiClient;
import com.kanchansali.api.Endpoints;
import com.kanchansali.specifications.RequestSpecs;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserApiTest extends BaseApiTest {

    @Test(groups = {"smoke", "api"})
    public void getUser1() {

        System.out.println(
                "getUser1 running on Thread : "
                        + Thread.currentThread().getId());

        ApiClient apiClient = new ApiClient();

        Response response =
                apiClient.get(Endpoints.USERS + "/2");

        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(groups = {"smoke", "api"})
    public void getUser2() {

        System.out.println(
                "getUser2 running on Thread : "
                        + Thread.currentThread().getId());

        ApiClient apiClient = new ApiClient();

        Response response =
                apiClient.get(Endpoints.USERS + "/3");

        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(groups = {"smoke", "api"})
    public void getUser3() {

        System.out.println(
                "getUser3 running on Thread : "
                        + Thread.currentThread().getId());

        ApiClient apiClient = new ApiClient();

        Response response =
                apiClient.get(Endpoints.USERS + "/4");

        Assert.assertEquals(response.statusCode(), 200);
    }
}