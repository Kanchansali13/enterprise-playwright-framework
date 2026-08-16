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

    /**
     * Initialize Playwright and Browser once per TestNG thread.
     */
    private static void initializeBrowser() {

        long threadId = Thread.currentThread().getId();

        System.out.println(
                "BROWSER INIT - Thread: " + threadId
        );

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

        System.out.println(
                "BROWSER CREATED - Thread: " + threadId
        );
    }

    /**
     * Create a new isolated BrowserContext and Page
     * for every test method.
     */
    public static void init() {

        long threadId = Thread.currentThread().getId();

        System.out.println(
                "PLAYWRIGHT INIT - Thread: " + threadId
        );

        // Create Playwright + Browser only once per thread
        if (browser.get() == null) {
            initializeBrowser();
        }

        // Safety check
        if (page.get() != null) {
            System.out.println(
                    "PAGE ALREADY INITIALIZED - Thread: "
                            + threadId
            );
            return;
        }

        Browser br = browser.get();

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

    /**
     * Close only the Context + Page after each test.
     * Browser and Playwright remain alive for the thread.
     */
    public static void close() {

        long threadId = Thread.currentThread().getId();

        System.out.println(
                "TEST CLEANUP - Thread: " + threadId
        );

        try {

            BrowserContext ctx = context.get();

            if (ctx != null) {
                ctx.close();
            }

        } finally {

            page.remove();
            context.remove();

            System.out.println(
                    "CONTEXT CLOSED - Thread: " + threadId
            );
        }
    }

    /**
     * Close Browser + Playwright when the thread is finished.
     */
    public static void shutdownThread() {

        long threadId = Thread.currentThread().getId();

        System.out.println(
                "BROWSER SHUTDOWN - Thread: " + threadId
        );

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

                browser.remove();
                playwright.remove();
            }
        }
    }
}