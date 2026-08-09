package com.kanchansali.driver;

import com.kanchansali.config.ConfigReader;
import com.microsoft.playwright.*;

public class PlaywrightManager {

    private static final ThreadLocal<Playwright> playwright =
            new ThreadLocal<>();

    private static final ThreadLocal<Browser> browser =
            new ThreadLocal<>();

    private static final ThreadLocal<BrowserContext> context =
            new ThreadLocal<>();

    private static final ThreadLocal<Page> page =
            new ThreadLocal<>();

    private PlaywrightManager() {
    }

    public static void init() {

        long threadId = Thread.currentThread().getId();

        System.out.println(
                "PLAYWRIGHT INIT - Thread: " + threadId
        );

        // Prevent accidental double initialization
        if (page.get() != null) {
            System.out.println(
                    "PLAYWRIGHT ALREADY INITIALIZED - Thread: " + threadId
            );
            return;
        }

        Playwright pw = Playwright.create();
        playwright.set(pw);

        String browserName =
                ConfigReader.get("browser");

        boolean headless =
                ConfigReader.getBoolean("headless");

        BrowserType browserType;

        switch (browserName.toLowerCase()) {

            case "chromium":
                browserType = pw.chromium();
                break;

            case "firefox":
                browserType = pw.firefox();
                break;

            case "webkit":
                browserType = pw.webkit();
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browserName
                );
        }

        Browser br = browserType.launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(headless)
        );

        browser.set(br);

        BrowserContext ctx = br.newContext();
        context.set(ctx);

        Page pg = ctx.newPage();
        page.set(pg);

        pg.setDefaultTimeout(
                ConfigReader.getInt("timeout")
        );

        System.out.println(
                "PAGE CREATED - Thread: " + threadId
        );
    }

    public static Page getPage() {

        Page currentPage = page.get();

        if (currentPage == null) {
            throw new IllegalStateException(
                    "Page is not initialized for Thread: "
                            + Thread.currentThread().getId()
            );
        }

        return currentPage;
    }

    public static void close() {

        long threadId = Thread.currentThread().getId();

        System.out.println(
                "PLAYWRIGHT CLOSE - Thread: " + threadId
        );

        try {

            Page pg = page.get();

            if (pg != null && !pg.isClosed()) {
                pg.close();
            }

        } finally {

            try {

                BrowserContext ctx = context.get();

                if (ctx != null) {
                    ctx.close();
                }

            } finally {

                try {

                    Browser br = browser.get();

                    if (br != null) {
                        br.close();
                    }

                } finally {

                    try {

                        Playwright pw = playwright.get();

                        if (pw != null) {
                            pw.close();
                        }

                    } finally {

                        page.remove();
                        context.remove();
                        browser.remove();
                        playwright.remove();
                    }
                }
            }
        }
    }
}