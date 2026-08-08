package com.kanchansali.tests;

import com.kanchansali.api.UserApi;
import com.kanchansali.utils.TokenManager;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserApiTest extends BaseApiTest {

    @Test
    public void deleteUser() {

        String token = TokenManager.getToken();

        Response response =
                UserApi.deleteUser(token, 1);

        Assert.assertEquals(response.getStatusCode(), 200);

        System.out.println("User deleted successfully.");
    }
}