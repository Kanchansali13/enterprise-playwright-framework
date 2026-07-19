package com.kanchansali.tests;

import com.kanchansali.api.UserApi;
import com.kanchansali.models.ResponsePojo;
import com.kanchansali.models.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutUserApiTest extends BaseApiTest {

    @Test
    public void updateUserTest() {

        User user =
                new User("Kanchan", "Senior SDET");

        Response response =
                UserApi.updateUser(String.valueOf(2), user);

        response.prettyPrint();

        ResponsePojo responsePojo =
                response.as(ResponsePojo.class);

        Assert.assertEquals(response.statusCode(), 200);

        Assert.assertEquals(responsePojo.getName(), "Kanchan");

        Assert.assertEquals(responsePojo.getJob(), "Senior SDET");

        Assert.assertNotNull(responsePojo.getUpdatedAt());

    }
}