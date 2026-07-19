package com.kanchansali.tests;

import com.kanchansali.api.ApiClient;
import com.kanchansali.api.Endpoints;
import com.kanchansali.specifications.RequestSpecs;
import com.kanchansali.specifications.ResponseSpecs;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserApiTest extends BaseApiTest {

    public Response get(String endpoint) {

        return RestAssured
                .given(RequestSpecs.getRequestSpec())
                .when()
                .get(endpoint);
    }

//    @Test
//    public void getSingleUser() {
//
//        Response response = apiClient.get(Endpoints.USER);
//
//        response.prettyPrint();
//
//        response.then()
//                .spec(ResponseSpecs.successResponse());
//
//        Assert.assertEquals(
//                response.jsonPath().getInt("data.id"),
//                2);
//
//        Assert.assertEquals(
//                response.jsonPath().getString("data.first_name"),
//                "Janet");
//
//        Assert.assertEquals(
//                response.jsonPath().getString("data.last_name"),
//                "Weaver");
//
//        Assert.assertEquals(
//                response.jsonPath().getString("data.email"),
//                "janet.weaver@reqres.in");
//    }

    @Test(groups = {"smoke", "api"})
    public void getSingleUser() {

    }

    @Test(groups = {"smoke","api"})
    public void getUser1() {

        System.out.println(
                "Running on Thread : " + Thread.currentThread().getId());

        ApiClient apiClient = new ApiClient();

        Response response = apiClient.get(Endpoints.USERS + "/2");

        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(groups = {"smoke","api"})
    public void getUser2() {

        System.out.println(
                "Running on Thread : " + Thread.currentThread().getId());

        ApiClient apiClient = new ApiClient();

        Response response = apiClient.get(Endpoints.USERS + "/3");

        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(groups = {"smoke","api"})
    public void getUser3() {

        System.out.println(
                "Running on Thread : " + Thread.currentThread().getId());

        ApiClient apiClient = new ApiClient();

        Response response = apiClient.get(Endpoints.USERS + "/4");

        Assert.assertEquals(response.statusCode(),200);
    }
}