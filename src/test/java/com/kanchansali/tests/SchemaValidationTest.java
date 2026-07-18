package com.kanchansali.tests;


import com.kanchansali.api.ApiClient;
import com.kanchansali.api.Endpoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import static com.kanchansali.api.Endpoints.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaValidationTest {
    @Test
    public void validateUserSchema() {

        ApiClient api = new ApiClient();

        Response response = api.get(Endpoints.USERS + "/2");

        Assert.assertEquals(response.statusCode(), 200);

        response.then().assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/user-schema.json"));
    }
}
