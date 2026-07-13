package com.kanchansali.tests;
import com.kanchansali.base.BaseTest;
import com.kanchansali.config.ConfigReader;
import com.kanchansali.pages.InventoryPage;
import com.kanchansali.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifySuccessfulLogin() {

        page.navigate(ConfigReader.get("base.url"));

        LoginPage loginPage = new LoginPage(page);

        InventoryPage inventoryPage = loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password"));

        Assert.assertTrue(
                inventoryPage.getTitle().contains("Swag Labs")
        );

    }
}