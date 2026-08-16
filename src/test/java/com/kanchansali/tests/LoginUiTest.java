package com.kanchansali.tests;

import com.kanchansali.base.BaseTest;
import com.kanchansali.config.ConfigReader;
import com.kanchansali.pages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUiTest extends BaseTest {

    @Test
    public void validLoginTest() {

        getLoginPage().open();

        InventoryPage inventoryPage =
                getLoginPage().login(
                        ConfigReader.get("username"),
                        ConfigReader.get("password")
                );

        Assert.assertTrue(
                inventoryPage.isInventoryDisplayed(),
                "Inventory page should be displayed after successful login"
        );
    }
}