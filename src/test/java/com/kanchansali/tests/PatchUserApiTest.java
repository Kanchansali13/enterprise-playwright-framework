package com.kanchansali.tests;

import com.kanchansali.api.UserApi;
import com.kanchansali.models.ResponsePojo;
import com.kanchansali.models.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PatchUserApiTest extends BaseApiTest {

    @Test
    public void patchUserTest(){

        Map<String,String> requestBody = new HashMap<>();

        requestBody.put("name","Kanchan");
        requestBody.put("job","SDET");


        Response response =
                UserApi.patchUser("2", new User());


        response.prettyPrint();


        Assert.assertEquals(
                response.getStatusCode(),
                200
        );
    }
}