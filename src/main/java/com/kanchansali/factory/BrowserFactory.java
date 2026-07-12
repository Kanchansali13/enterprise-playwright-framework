package com.kanchansali.factory;

import com.kanchansali.config.ConfigReader;
import com.microsoft.playwright.*;

public class BrowserFactory {

    public static Browser createBrowser(Playwright playwright) {

        String browserName = ConfigReader.get("browser");

        boolean headless =
                Boolean.parseBoolean(ConfigReader.get("headless"));

        BrowserType.LaunchOptions options =
                new BrowserType.LaunchOptions()
                        .setHeadless(headless);

        switch (browserName.toLowerCase()) {

            case "firefox":
                return playwright.firefox().launch(options);

            case "edge":
                return playwright.chromium().launch(
                        options.setChannel("msedge"));

            default:
                return playwright.chromium().launch(options);

        }

    }

}