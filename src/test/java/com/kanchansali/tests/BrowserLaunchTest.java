package com.kanchansali.tests;

import com.kanchansali.base.BaseTest;
import com.kanchansali.config.ConfigReader;
import com.kanchansali.factory.BrowserFactory;
import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserLaunchTest extends BaseTest {
    @Test
    public void launchBrowser() {

        page.navigate(ConfigReader.get("base.url"));

        System.out.println(page.title());

        Assert.assertTrue(page.title().contains("Playwright"));
    }
}
