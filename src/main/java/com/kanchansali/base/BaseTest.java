package com.kanchansali.base;

import com.kanchansali.driver.PlaywrightManager;
import com.kanchansali.pages.InventoryPage;
import com.kanchansali.pages.LoginPage;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Page page;
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;

    public Page getPage() {
        return page;
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

        // Create Playwright instance for this thread
        PlaywrightManager.init();

        // Get Page belonging to this thread
        page = PlaywrightManager.getPage();

        // Initialize page objects using this thread's Page
        loginPage = new LoginPage(page);

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

        // Close Playwright resources belonging to this thread
        PlaywrightManager.close();

        // Clear test-level references
        page = null;
        loginPage = null;
        inventoryPage = null;

        System.out.println(
                "PLAYWRIGHT CLOSE - Thread: " + threadId
        );
    }
}