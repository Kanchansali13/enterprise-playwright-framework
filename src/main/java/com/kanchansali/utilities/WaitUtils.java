package com.kanchansali.utilities;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class WaitUtils {

    private final Page page;

    public WaitUtils(Page page) {
        this.page = page;
    }

    public void waitForVisible(String selector) {
        page.locator(selector).waitFor();
    }

    public void waitForPageLoad() {
        page.waitForLoadState();
    }
}