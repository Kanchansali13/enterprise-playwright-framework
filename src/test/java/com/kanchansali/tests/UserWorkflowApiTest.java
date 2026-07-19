package com.kanchansali.tests;

import com.kanchansali.api.UserApi;
import com.kanchansali.models.ResponsePojo;
import com.kanchansali.models.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserWorkflowApiTest extends BaseApiTest {

    @Test
    public void userWorkflowTest() {

        // STEP 1 - Create User
        User createUser = new User("Kanchan", "QA");

        Response createResponse =
                UserApi.createUser(createUser);

        Assert.assertEquals(createResponse.statusCode(), 201);

        ResponsePojo createdUser =
                createResponse.as(ResponsePojo.class);

        String userId = createdUser.getId();

        System.out.println("Created User Id : " + userId);

        Assert.assertNotNull(userId);

        // STEP 2 - Update User

        User updateUser = new User("Kanchan", "Senior QA");

        Response updateResponse =
                UserApi.updateUser(userId, updateUser);

        Assert.assertEquals(updateResponse.statusCode(), 200);

        ResponsePojo updatedUser =
                updateResponse.as(ResponsePojo.class);

        Assert.assertEquals(updatedUser.getJob(), "Senior QA");

        // STEP 3 - Patch User

        User patchUser = new User();
        patchUser.setJob("Automation Lead");

        Response patchResponse =
                UserApi.patchUser(userId, patchUser);

        Assert.assertEquals(patchResponse.statusCode(), 200);

        // STEP 4 - Delete User

        Response deleteResponse =
                UserApi.deleteUser(userId);

        Assert.assertEquals(deleteResponse.statusCode(), 204);

    }
}