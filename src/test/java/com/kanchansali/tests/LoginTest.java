package com.kanchansali.tests;

import com.kanchansali.base.BaseTest;
import com.kanchansali.config.ConfigReader;
import com.kanchansali.pages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {

        getLoginPage().open();

        InventoryPage inventoryPage =
                getLoginPage().login(
                        ConfigReader.get("username"),
                        ConfigReader.get("password")
                );

        Assert.assertTrue(
                inventoryPage.isInventoryDisplayed()
        );
    }

    @Test
    public void invalidLogin() {

        getLoginPage().open();

        getLoginPage().login(
                "invalid_user",
                "invalid_password"
        );

        Assert.assertTrue(
                getLoginPage().isErrorDisplayed(),
                "Error message should be displayed"
        );
    }
}