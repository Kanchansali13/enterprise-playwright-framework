package com.kanchansali.tests;

import com.kanchansali.base.BaseTest;
import com.kanchansali.config.ConfigReader;
import com.kanchansali.pages.InventoryPage;
import com.kanchansali.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {

    @Test
    public void verifyInventoryPage() {

        getLoginPage().open();

        InventoryPage inventoryPage =
                getLoginPage().login(
                        ConfigReader.get("username"),
                        ConfigReader.get("password")
                );

        Assert.assertEquals(
                inventoryPage.getPageTitle(),
                "Products"
        );

        Assert.assertEquals(
                inventoryPage.getProductCount(),
                6
        );
    }

    @Test
    public void addProductToCart() {

        LoginPage loginPage = getLoginPage();

        loginPage.open();

        InventoryPage inventoryPage =
                loginPage.login(
                        ConfigReader.get("username"),
                        ConfigReader.get("password")
                );

        inventoryPage.addProductToCart("Sauce Labs Backpack");

        Assert.assertEquals(
                inventoryPage.getCartItemCount(),
                1
        );
    }
}