package com.kanchansali.pages;

import com.kanchansali.utilities.WaitUtils;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasePage {

    protected final Page page;
    protected final WaitUtils waitUtils;

    public BasePage(Page page) {
        this.page = page;
        this.waitUtils = new WaitUtils(page);
    }

    protected Locator locator(String selector) {
        return page.locator(selector);
    }

    protected void click(String selector) {
        waitUtils.waitForVisible(selector);
        locator(selector).click();
    }

    protected void type(String selector, String text) {
        waitUtils.waitForVisible(selector);
        locator(selector).fill(text);
    }
}