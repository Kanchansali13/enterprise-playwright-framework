package com.kanchansali.tests;

import com.kanchansali.driver.PlaywrightManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseUiTest {

    @BeforeMethod
    public void setUp() {
        PlaywrightManager.init();
    }

    @AfterMethod
    public void tearDown() {
        PlaywrightManager.close();
    }
}