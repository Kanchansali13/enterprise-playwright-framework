package com.kanchansali.tests;

import com.kanchansali.base.BaseTest;
import com.kanchansali.pages.InventoryPage;
import com.kanchansali.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class InventoryTest extends BaseTest {

    @Test

    public void verifyInventoryCount() {

        LoginPage loginPage = new LoginPage(page);

        loginPage.open();

        InventoryPage inventoryPage = loginPage.login("standard_user","secret_sauce");

        Assert.assertEquals(inventoryPage.getProductCount(), 6);

    }

    @Test

    public void addSingleProduct() {

        LoginPage loginPage = new LoginPage(page);

        loginPage.open();

        InventoryPage inventoryPage =

                loginPage.login("standard_user","secret_sauce");

        inventoryPage.addProduct("Sauce Labs Backpack");

        Assert.assertEquals(inventoryPage.getCartCount(), 1);

    }
}
