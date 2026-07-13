package com.kanchansali.tests;

import com.kanchansali.base.BaseTest;
import com.kanchansali.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserLaunchTest extends BaseTest {
    @Test
    public void launchBrowser() {




        LoginPage loginPage = new LoginPage(page);

        //loginPage.open();

        Assert.assertTrue(page.title().contains("Playwright"));
    }
}
