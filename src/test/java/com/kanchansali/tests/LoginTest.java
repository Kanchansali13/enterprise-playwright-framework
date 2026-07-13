package com.kanchansali.tests;

import com.kanchansali.base.BaseTest;
import com.kanchansali.pages.InventoryPage;
import com.kanchansali.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test

    public void validLogin() {

        LoginPage loginPage = new LoginPage(page);

        loginPage.open();

        InventoryPage inventoryPage =
                loginPage.login("standard_user","secret_sauce");

        Assert.assertTrue(inventoryPage.isInventoryDisplayed());

    }

    @Test

    public void invalidLogin() {

        LoginPage loginPage = new LoginPage(page);

        loginPage.open();

        loginPage.login("wrong","wrong");

        Assert.assertTrue(loginPage.getErrorMessage().contains("Username"));

    }

}