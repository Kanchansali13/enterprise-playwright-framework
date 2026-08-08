package com.kanchansali.api;

public class Endpoints {

    private Endpoints() {
    }

    // =========================
    // DummyJSON
    // =========================

    public static final String DUMMY_BASE =
            "https://dummyjson.com";

    public static final String USERS = "/users";

    public static final String AUTH_BASE =
            DUMMY_BASE + "/auth";

    public static final String LOGIN =
            "/login";

    public static final String CURRENT_USER =
            "/me";


    // =========================
    // JSONPlaceholder
    // =========================

    public static final String JSONPLACEHOLDER_BASE =
            "https://jsonplaceholder.typicode.com";


    // =========================
    // Existing framework
    // =========================

    public static final String BASE_URL =
            DUMMY_BASE;


}