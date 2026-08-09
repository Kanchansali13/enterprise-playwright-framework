package com.kanchansali.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
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
                        .setWaitUntil(WaitUntilState.COMMIT)
                        .setTimeout(30000)
        );

        page.locator("#user-name").waitFor(
                new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.VISIBLE)
                        .setTimeout(30000)
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

    public String getErrorMessage() {
        return page.locator("[data-test='error']").textContent();
    }
}