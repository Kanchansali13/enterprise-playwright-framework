package com.kanchansali.tests;

import com.kanchansali.base.BaseTest;
import dataproviders.LoginDataProvider;
import com.kanchansali.pages.InventoryPage;
import com.kanchansali.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
    public void loginTest(String username,
                          String password,
                          String expected) {

        LoginPage loginPage = new LoginPage(page);

        loginPage.open();

        InventoryPage inventoryPage =
                loginPage.login(username, password);

        if (expected.equalsIgnoreCase("PASS")) {

            Assert.assertTrue(
                    inventoryPage.isInventoryDisplayed(),
                    "Login should be successful");

        } else {

            Assert.assertTrue(
                    loginPage.isErrorDisplayed(),
                    "Error message should be displayed");

        }
    }

    @Test(groups = {"smoke", "ui"})
    public void validLoginTest() {

    }
}