package com.kanchansali.utils;

import io.restassured.response.Response;

public class ApiUtils {

    public static String getString(Response response, String path) {
        return response.jsonPath().getString(path);
    }

    public static int getInt(Response response, String path) {
        return response.jsonPath().getInt(path);
    }

    public static boolean hasKey(Response response, String key) {
        return response.jsonPath().getMap("$").containsKey(key);
    }
}
