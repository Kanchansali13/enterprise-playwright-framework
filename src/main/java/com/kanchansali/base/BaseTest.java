package com.kanchansali.base;

import com.kanchansali.driver.PlaywrightManager;
import com.kanchansali.pages.InventoryPage;
import com.kanchansali.pages.LoginPage;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected ThreadLocal<Page> page = new ThreadLocal<>();
    protected ThreadLocal<LoginPage> loginPage = new ThreadLocal<>();
    protected ThreadLocal<InventoryPage> inventoryPage = new ThreadLocal<>();

    public Page getPage() {
        return page.get();
    }

    public LoginPage getLoginPage() {
        return loginPage.get();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        long threadId = Thread.currentThread().getId();

        System.out.println(
                "SETUP - Test: "
                        + getClass().getSimpleName()
                        + " | Thread: "
                        + threadId
        );

        PlaywrightManager.init();

        Page currentPage = PlaywrightManager.getPage();

        page.set(currentPage);
        loginPage.set(new LoginPage(currentPage));

        System.out.println(
                "PAGE CREATED - Thread: " + threadId
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        long threadId = Thread.currentThread().getId();

        System.out.println(
                "TEARDOWN - Test: "
                        + getClass().getSimpleName()
                        + " | Thread: "
                        + threadId
        );

        try {
            PlaywrightManager.close();
        } finally {

            page.remove();
            loginPage.remove();
            inventoryPage.remove();

            System.out.println(
                    "PLAYWRIGHT CLOSE - Thread: " + threadId
            );
        }
    }
}