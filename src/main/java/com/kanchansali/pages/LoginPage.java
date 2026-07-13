package com.kanchansali.pages;

import com.kanchansali.config.ConfigReader;
import com.kanchansali.constants.LoginPageLocators;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    public LoginPage(Page page) {
        super(page);
    }

    public void open() {

        page.navigate(ConfigReader.get("base.url"));

    }

    public InventoryPage login(String username, String password) {

        type(LoginPageLocators.USERNAME, username);

        type(LoginPageLocators.PASSWORD, password);

        click(LoginPageLocators.LOGIN_BUTTON);

        return new InventoryPage(page);

    }

    public String getErrorMessage() {

        return locator(LoginPageLocators.ERROR_MESSAGE).textContent();

    }

}