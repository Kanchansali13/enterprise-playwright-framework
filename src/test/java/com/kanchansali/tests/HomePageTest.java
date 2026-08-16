package com.kanchansali.tests;

import com.kanchansali.base.BaseTest;
import com.kanchansali.config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void launchBrowser() {

        getPage().navigate(
                ConfigReader.get("base.url")
        );

        Assert.assertEquals(
                getPage().title(),
                "Swag Labs"
        );
    }
}