package com.kanchansali.tests;

import com.kanchansali.base.BaseTest;
import com.kanchansali.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    @Test
    public void completePurchase() {

        LoginPage loginPage = new LoginPage(page);

        loginPage.open();

        InventoryPage inventoryPage =
                loginPage.login("standard_user","secret_sauce");

        inventoryPage.addProduct("Sauce Labs Backpack");

        CartPage cartPage = inventoryPage.openCart();

        CheckoutPage checkoutPage = cartPage.checkout();

        CheckoutOverviewPage overviewPage =
                checkoutPage.enterCheckoutInformation("Kanchan", "Sali", "411057");

        CheckoutCompletePage completePage =
                overviewPage.finishOrder();

        Assert.assertEquals(
                completePage.getSuccessMessage(),
                "Thank you for your order!");
    }
}
