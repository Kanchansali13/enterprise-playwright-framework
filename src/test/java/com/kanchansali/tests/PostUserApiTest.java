package com.kanchansali.tests;
import com.github.javafaker.Faker;

import com.kanchansali.api.ApiClient;
import com.kanchansali.api.Endpoints;
import com.kanchansali.models.User;
import com.kanchansali.models.UserResponse;
import com.kanchansali.specifications.RequestSpecs;
import com.kanchansali.specifications.ResponseSpecs;
import com.kanchansali.utils.LoggerUtil;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostUserApiTest extends BaseApiTest {

    private static final Logger logger =
            LoggerUtil.getLogger(PostUserApiTest.class);

    Faker faker=new Faker();

    User user = new User(
            faker.name().firstName(),
            "Automation Engineer");


//    @Test
//    public void createUser() {
//
//        ApiClient apiClient = new ApiClient();
//
//        User user = new User("Kanchan", "SDET");
//
//        Response response = apiClient.post(Endpoints.USERS, user);
//
//        response.prettyPrint();
//
//        response.then()
//                .spec(ResponseSpecs.createdResponse());
//
//
//        UserResponse userResponse = response.as(UserResponse.class);
//
//        Assert.assertEquals(userResponse.getName(), "Kanchan");
//        Assert.assertEquals(userResponse.getJob(), "SDET");
//
//        System.out.println(userResponse.getId());
//        System.out.println(userResponse.getCreatedAt());
//    }
@Test(groups = {"regression", "api"})
public void createUser() {

    logger.info("Creating User");

    ApiClient apiClient = new ApiClient();

    User user = new User("Kanchan", "SDET");

    Response response = apiClient.post(Endpoints.USERS, user);

    logger.info("Status Code : {}", response.statusCode());
    logger.info("Response : {}", response.asPrettyString());

    Assert.assertEquals(response.statusCode(), 201);
    Assert.assertEquals(response.jsonPath().getString("name"), "Kanchan");
    Assert.assertEquals(response.jsonPath().getString("job"), "SDET");
}

    public Response post(String endpoint, Object body) {

        logger.info("POST Request: {}", endpoint);
        logger.info("Request Body: {}", body);
        return RestAssured
                    .given(RequestSpecs.getRequestSpec())
                    .body(body)
                    .when()
                    .post(endpoint);


    }



}
