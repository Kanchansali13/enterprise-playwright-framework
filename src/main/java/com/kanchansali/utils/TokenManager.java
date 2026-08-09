package com.kanchansali.utils;

import com.kanchansali.api.AuthApi;
import com.kanchansali.config.ConfigReader;
import com.kanchansali.models.LoginRequest;
import com.kanchansali.models.LoginResponse;
import com.kanchansali.utils.exceptions.ApiException;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;

public class TokenManager {

    private static final Logger logger =
            LoggerUtil.getLogger(TokenManager.class);

    private static String token;

    private TokenManager() {
    }

    public static String getToken() {

        if (token == null || token.isBlank()) {

            logger.info("Access token not found. Performing login.");

            LoginRequest request =
                    new LoginRequest(
                            ConfigReader.get("api.username"),
                            ConfigReader.get("api.password")
                    );
            Response response = AuthApi.login(request);

            if (response.statusCode() != 200) {

                logger.error(
                        "Login failed. Status code: {}",
                        response.statusCode()
                );

                throw new ApiException(
                        "Login failed. Status Code: "
                                + response.statusCode()
                                + ", Response: "
                                + response.asPrettyString()
                );
            }

            if (!response.getContentType().contains("application/json")) {

                logger.error(
                        "Unexpected login response Content-Type: {}",
                        response.getContentType()
                );

                throw new ApiException(
                        "Login failed. Expected JSON response but received Content-Type: "
                                + response.getContentType()
                );
            }

            try {

                LoginResponse login =
                        response.as(LoginResponse.class);

                token = login.getAccessToken();

            } catch (Exception e) {

                logger.error("Failed to parse login response.", e);

                throw new ApiException(
                        "Failed to parse login response.",
                        e
                );
            }

            if (token == null || token.isBlank()) {

                logger.error("Login succeeded but access token is missing.");

                throw new ApiException(
                        "Login succeeded but access token is missing."
                );
            }

            logger.info("Access token generated successfully.");

        } else {

            logger.info("Using existing cached access token.");
        }

        return token;
    }
}