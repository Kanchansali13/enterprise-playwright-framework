package com.kanchansali.tests;

import com.kanchansali.api.UserApi;
import com.kanchansali.models.ResponsePojo;
import com.kanchansali.models.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatchUserApiTest extends BaseApiTest {

    @Test
    public void patchUserTest() {

        User user = new User();
        user.setJob("Senior SDET");

        Response response =
                UserApi.patchUser("2", user);

        ResponsePojo responsePojo =
                response.as(ResponsePojo.class);

        Assert.assertEquals(response.getStatusCode(), 200);

        Assert.assertEquals(responsePojo.getJob(), "Senior SDET");

        Assert.assertNotNull(responsePojo.getUpdatedAt());

        System.out.println(responsePojo);
    }
}