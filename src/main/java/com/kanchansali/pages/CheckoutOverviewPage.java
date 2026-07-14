package com.kanchansali.pages;

import com.kanchansali.constants.CheckoutPageLocators;
import com.microsoft.playwright.Page;

public class CheckoutOverviewPage extends BasePage {

    public CheckoutOverviewPage(Page page) {
        super(page);
    }

    public CheckoutCompletePage finishOrder() {

        click(CheckoutPageLocators.FINISH_BUTTON);

        return new CheckoutCompletePage(page);
    }

}