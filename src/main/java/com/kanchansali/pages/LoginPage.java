package com.kanchansali.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;

public class LoginPage {

    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void open() {
        page.navigate(
                "https://www.saucedemo.com/",
                new Page.NavigateOptions()
                        .setWaitUntil(WaitUntilState.DOMCONTENTLOADED)
        );
    }

    public InventoryPage login(String username, String password) {

        page.locator("#user-name").fill(username);
        page.locator("#password").fill(password);
        page.locator("#login-button").click();

        return new InventoryPage(page);
    }

    public boolean isErrorDisplayed() {
        return page.locator("[data-test='error']").isVisible();
    }
}