package com.kanchansali.tests;

import com.kanchansali.api.Endpoints;
import com.kanchansali.specifications.ResponseSpecs;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserApiTest extends BaseApiTest {

    @Test
    public void getSingleUser() {

        Response response = apiClient.get(Endpoints.USER);

        response.prettyPrint();

        response.then()
                .spec(ResponseSpecs.successResponse());

        Assert.assertEquals(
                response.jsonPath().getInt("data.id"),
                2);

        Assert.assertEquals(
                response.jsonPath().getString("data.first_name"),
                "Janet");

        Assert.assertEquals(
                response.jsonPath().getString("data.last_name"),
                "Weaver");

        Assert.assertEquals(
                response.jsonPath().getString("data.email"),
                "janet.weaver@reqres.in");
    }
}