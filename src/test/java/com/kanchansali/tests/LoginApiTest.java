package com.kanchansali.tests;

import com.kanchansali.api.AuthApi;
import com.kanchansali.api.UserApi;
import com.kanchansali.models.CurrentUserResponse;
import com.kanchansali.models.LoginRequest;
import com.kanchansali.models.LoginResponse;
import com.kanchansali.utils.TokenManager;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginApiTest extends BaseApiTest {
    @Test
    public void loginTest() {

        String token = TokenManager.getToken();

        Response userResponse =
                UserApi.getCurrentUser(token);

        CurrentUserResponse user =
                userResponse.as(CurrentUserResponse.class);

        Assert.assertEquals(user.getUsername(), "emilys");
        Assert.assertEquals(user.getFirstName(), "Emily");
        Assert.assertEquals(user.getLastName(), "Johnson");



    }
}