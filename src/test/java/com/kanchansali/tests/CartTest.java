package com.kanchansali.tests;

import com.kanchansali.base.BaseTest;
import com.kanchansali.pages.CartPage;
import com.kanchansali.pages.CheckoutPage;
import com.kanchansali.pages.InventoryPage;
import com.kanchansali.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void verifyProductAddedToCart() {

        LoginPage loginPage = new LoginPage(page);

        loginPage.open();

        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addProduct("Sauce Labs Backpack");

        CartPage cartPage = inventoryPage.openCart();

        Assert.assertTrue(cartPage.isProductPresent("Sauce Labs Backpack"));
    }

    @Test
    public void verifyCartItemCount() {

        LoginPage loginPage = new LoginPage(page);

        loginPage.open();

        InventoryPage inventoryPage =
                loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addProduct("Sauce Labs Backpack");
        inventoryPage.addProduct("Sauce Labs Bike Light");
        inventoryPage.addProduct("Sauce Labs Bolt T-Shirt");

        CartPage cartPage = inventoryPage.openCart();

        Assert.assertEquals(cartPage.getCartItemCount(), 3);
    }

    @Test
    public void removeProductFromCart() {

        LoginPage loginPage = new LoginPage(page);

        loginPage.open();

        InventoryPage inventoryPage =
                loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addProduct("Sauce Labs Backpack");

        CartPage cartPage = inventoryPage.openCart();

        cartPage.removeProduct("Sauce Labs Backpack");

        Assert.assertEquals(cartPage.getCartItemCount(), 0);
    }

    @Test
    public void verifyCheckoutNavigation() {

        LoginPage loginPage = new LoginPage(page);

        loginPage.open();

        InventoryPage inventoryPage =
                loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addProduct("Sauce Labs Backpack");

        CartPage cartPage = inventoryPage.openCart();

        CheckoutPage checkoutPage = cartPage.checkout();

        Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed());

    }
}
