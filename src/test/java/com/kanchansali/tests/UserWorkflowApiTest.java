package com.kanchansali.tests;

import com.kanchansali.api.UserApi;
import com.kanchansali.models.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserWorkflowApiTest extends BaseApiTest {
    String token = com.kanchansali.utils.TokenManager.getToken();

    @Test
    public void userWorkflowTest() {

        // Create User
        User createUser = new User(
                "Kanchan",
                "Sali",
                29
        );

        Response createResponse =
                UserApi.createUser(token,createUser);

        createResponse.prettyPrint();

        Assert.assertEquals(createResponse.statusCode(), 201);

        // DummyJSON doesn't actually create a database record.
        int userId = 1;

        // Update User
        User updateUser = new User(
                "Kanchan",
                "Patil",
                30
        );

        Response updateResponse =
                UserApi.updateUser(token,userId,updateUser);

        updateResponse.prettyPrint();

        Assert.assertEquals(updateResponse.statusCode(), 200);

        // Patch User
        User patchUser = new User();
        patchUser.setFirstName("Kanchan Updated");



        Response patchResponse =
                UserApi.patchUser(token, userId,patchUser);

        patchResponse.prettyPrint();

        Assert.assertEquals(patchResponse.statusCode(), 200);

        // Delete User

        Response deleteResponse =
                UserApi.deleteUser(token, userId);

        deleteResponse.prettyPrint();

        Assert.assertEquals(deleteResponse.statusCode(), 200);
    }
}