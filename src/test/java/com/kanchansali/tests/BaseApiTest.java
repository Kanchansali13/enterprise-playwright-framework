package com.kanchansali.tests;

import com.kanchansali.api.ApiClient;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {

    protected ApiClient apiClient;

    @BeforeClass
    public void setup() {
        apiClient = new ApiClient();
    }
}