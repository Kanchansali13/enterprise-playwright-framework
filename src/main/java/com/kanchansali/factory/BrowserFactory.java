package com.kanchansali.factory;

import com.microsoft.playwright.*;

public class BrowserFactory {

    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;


    public static Page initBrowser(){

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(100)
        );


        context = browser.newContext();

        page = context.newPage();

        page.setDefaultTimeout(30000);

        return page;
    }
}