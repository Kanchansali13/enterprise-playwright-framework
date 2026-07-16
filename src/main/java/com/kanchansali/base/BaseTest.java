package com.kanchansali.base;

import com.kanchansali.data.TestData;
import com.kanchansali.pages.InventoryPage;
import com.kanchansali.pages.LoginPage;
import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    public static Page page;

    @BeforeMethod
    public void setUp() {

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
        );

        context = browser.newContext();

        page = context.newPage();
    }

    @AfterMethod
    public void tearDown() {

        page.close();

        context.close();

        browser.close();

        playwright.close();
    }

    protected InventoryPage login() {

        LoginPage loginPage = new LoginPage(page);

        loginPage.open();

        return loginPage.login(
                TestData.USERNAME,
                TestData.PASSWORD);
    }
}