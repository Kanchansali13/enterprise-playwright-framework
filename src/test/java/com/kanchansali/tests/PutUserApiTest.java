package com.kanchansali.tests;

import com.kanchansali.api.UserApi;
import com.kanchansali.models.User;
import com.kanchansali.utils.TokenManager;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutUserApiTest extends BaseApiTest {

    @Test
    public void updateUserTest(){


        User user = new User();

        user.setFirstName("Kanchan");
        user.setLastName("Sali");
        String token = TokenManager.getToken();

        Response response =
                UserApi.updateUser(token,1, user);

        response.prettyPrint();

        Assert.assertEquals(
                response.getStatusCode(),
                200
        );
    }
}