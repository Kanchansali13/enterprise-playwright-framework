package com.kanchansali.utils;

import com.kanchansali.api.AuthApi;
import com.kanchansali.models.LoginRequest;
import com.kanchansali.models.LoginResponse;
import io.restassured.response.Response;

public class TokenManager {

    private static String token;

    public static String getToken() {

        if (token == null) {

            LoginRequest request =
                    new LoginRequest(
                            "emilys",
                            "emilyspass");

            Response response = AuthApi.login(request);

            System.out.println("Status Code : " + response.statusCode());
            System.out.println("Content Type: " + response.getContentType());

            response.prettyPrint();

            LoginResponse login = response.as(LoginResponse.class);
            token = login.getAccessToken();
        }

        return token;
    }
}