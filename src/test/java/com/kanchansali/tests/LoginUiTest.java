package com.kanchansali.tests;

import com.kanchansali.base.BaseTest;
import com.kanchansali.pages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUiTest extends BaseTest {

    @Test
    public void verifySuccessfulLogin() {

        loginPage.open();

        InventoryPage inventoryPage =
                loginPage.login(
                        "standard_user",
                        "secret_sauce"
                );

        Assert.assertTrue(
                inventoryPage.isInventoryDisplayed(),
                "User was not redirected to the Inventory page after login"
        );
    }
}