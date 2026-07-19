package com.kanchansali.tests;

import com.kanchansali.api.UserApi;
import com.kanchansali.models.ResponsePojo;
import com.kanchansali.models.UpdateUser;
import com.kanchansali.models.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PutUserApiTest extends BaseApiTest {

    @Test
    public void updateUser() {

        User user = new User("Kanchan", "Senior SDET");

        Response response = UserApi.updateUser(2, user);

        ResponsePojo responsePojo = response.as(ResponsePojo.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(responsePojo.getName(), "Kanchan");
        Assert.assertEquals(responsePojo.getJob(), "Senior SDET");
        Assert.assertNotNull(responsePojo.getUpdatedAt());

        System.out.println(responsePojo.getUpdatedAt());
    }
}