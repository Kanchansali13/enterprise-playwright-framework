package com.kanchansali.tests;
import com.github.javafaker.Faker;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import com.kanchansali.models.User;
import com.kanchansali.specifications.RequestSpecs;
import com.kanchansali.utils.LoggerUtil;
import com.kanchansali.utils.TokenManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.kanchansali.api.UserApi;



public class PostUserApiTest extends BaseApiTest {

    @Test
    public void createUser() {
        String token = TokenManager.getToken();

        User user = new User();

        user.setFirstName("Kanchan");
        user.setLastName("Sali");
        user.setAge(29);

        Response response =
                UserApi.createUser(token,user);

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 201);

        User createdUser =
                response.as(User.class);

        Assert.assertEquals(createdUser.getFirstName(), "Kanchan");
        Assert.assertEquals(createdUser.getLastName(), "Sali");
        Assert.assertEquals(createdUser.getAge(), 29);
    }

}
