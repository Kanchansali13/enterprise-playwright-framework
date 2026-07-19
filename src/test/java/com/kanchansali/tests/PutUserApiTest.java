package com.kanchansali.tests;

import com.kanchansali.api.UserApi;
import com.kanchansali.models.ResponsePojo;
import com.kanchansali.models.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutUserApiTest extends BaseApiTest {

    @Test
    public void updateUserTest(){

        Response response =
                UserApi.patchUser("2", new User());

        response.prettyPrint();

        Assert.assertEquals(
                response.getStatusCode(),
                200
        );
    }
}