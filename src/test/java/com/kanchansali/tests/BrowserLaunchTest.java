package com.kanchansali.tests;

import com.kanchansali.factory.BrowserFactory;
import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class BrowserLaunchTest {

    @Test
    public void launchBrowser() {

        Browser browser = BrowserFactory.createBrowser();

        Page page = browser.newPage();

        page.navigate("https://www.google.com");

        System.out.println(page.title());

        browser.close();
    }
}