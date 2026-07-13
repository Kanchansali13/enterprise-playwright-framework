package com.kanchansali.pages;

import com.microsoft.playwright.Page;

public class CheckoutPage extends BasePage {

    public CheckoutPage(Page page) {
        super(page);
    }

    public boolean isCheckoutPageDisplayed() {

        return page.url().contains("checkout-step-one");
    }
}