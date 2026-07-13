package com.kanchansali.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasePage {

    protected final Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    protected Locator locator(String selector) {
        return page.locator(selector);
    }

    protected void click(String selector) {
        locator(selector).click();
    }

    protected void type(String selector, String text) {
        locator(selector).fill(text);
    }

    protected String getText(String selector) {
        return locator(selector).textContent();
    }

    protected boolean isVisible(String selector) {
        return locator(selector).isVisible();
    }
}