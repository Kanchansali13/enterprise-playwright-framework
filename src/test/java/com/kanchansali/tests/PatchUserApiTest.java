package com.kanchansali.tests;

import com.kanchansali.api.UserApi;
import com.kanchansali.constants.Endpoints;
import com.kanchansali.models.ResponsePojo;
import com.kanchansali.models.User;
import com.kanchansali.specifications.RequestSpecs;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatchUserApiTest extends BaseApiTest {

    @Test
    public void patchUser() {

        User user = new User("Kanchan", "Lead SDET");

        Response response = UserApi.patchUser(2, user);

        ResponsePojo responsePojo = response.as(ResponsePojo.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(responsePojo.getName(), "Kanchan");
        Assert.assertEquals(responsePojo.getJob(), "Lead SDET");
        Assert.assertNotNull(responsePojo.getUpdatedAt());

        System.out.println(responsePojo.getUpdatedAt());
    }

    public static Response deleteUser(int id) {

        return RestAssured
                .given(RequestSpecs.getRequestSpec())
                .when()
                .delete(Endpoints.USERS + "/" + id);
    }
}