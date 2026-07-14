package com.kanchansali.pages;

import com.kanchansali.constants.CheckoutPageLocators;
import com.microsoft.playwright.Page;

public class CheckoutPage extends BasePage {

    public CheckoutPage(Page page) {
        super(page);
    }

    public CheckoutOverviewPage enterCheckoutInformation(
            String firstName,
            String lastName,
            String postalCode) {

        type(CheckoutPageLocators.FIRST_NAME, firstName);

        type(CheckoutPageLocators.LAST_NAME, lastName);

        type(CheckoutPageLocators.POSTAL_CODE, postalCode);

        click(CheckoutPageLocators.CONTINUE_BUTTON);

        return new CheckoutOverviewPage(page);
    }

    public boolean isCheckoutPageDisplayed() {
        return page.url().contains("checkout-step-one");
    }

}