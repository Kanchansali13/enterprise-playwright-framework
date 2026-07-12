package com.kanchansali.factory;

import com.microsoft.playwright.*;

public class BrowserFactory {

    public static Browser createBrowser() {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
        );

        return browser;
    }
}