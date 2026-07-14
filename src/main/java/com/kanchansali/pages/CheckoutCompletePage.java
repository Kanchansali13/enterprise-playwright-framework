package com.kanchansali.pages;

import com.kanchansali.constants.CheckoutPageLocators;
import com.microsoft.playwright.Page;

public class CheckoutCompletePage extends BasePage {

    public CheckoutCompletePage(Page page) {
        super(page);
    }

    public String getSuccessMessage() {

        return locator(CheckoutPageLocators.COMPLETE_HEADER)
                .textContent();
    }

}