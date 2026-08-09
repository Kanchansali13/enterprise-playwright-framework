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

        System.out.println(
                "SETUP - Test: "
                        + getClass().getSimpleName()
                        + " | Thread: "
                        + Thread.currentThread().getId()
        );

        PlaywrightManager.init();

        page = PlaywrightManager.getPage();

        loginPage = new LoginPage(page);

        System.out.println(
                "PAGE CREATED - Thread: "
                        + Thread.currentThread().getId()
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        System.out.println(
                "TEARDOWN - Test: "
                        + getClass().getSimpleName()
                        + " | Thread: "
                        + Thread.currentThread().getId()
        );

        PlaywrightManager.close();

        System.out.println(
                "PLAYWRIGHT CLOSE - Thread: "
                        + Thread.currentThread().getId()
        );
    }
}