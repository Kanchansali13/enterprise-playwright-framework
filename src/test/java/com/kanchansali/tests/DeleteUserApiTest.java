package com.kanchansali.tests;

import com.kanchansali.api.UserApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserApiTest extends BaseApiTest {

    @Test
    public void deleteUser() {

        Response response = UserApi.deleteUser(2);

        Assert.assertEquals(response.getStatusCode(), 204);

        System.out.println("User deleted successfully.");
    }
}