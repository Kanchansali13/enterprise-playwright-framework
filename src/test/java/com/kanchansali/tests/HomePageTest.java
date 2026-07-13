package com.kanchansali.tests;

import com.kanchansali.base.BaseTest;
import com.kanchansali.config.ConfigReader;
import com.kanchansali.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void launchBrowser() {

        LoginPage loginPage = new LoginPage(page);

        page.navigate(ConfigReader.get("base.url"));

        Assert.assertEquals(page.title(), "Swag Labs");
    }
}