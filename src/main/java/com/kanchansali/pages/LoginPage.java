package com.kanchansali.pages;

import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    private static final String USERNAME = "#user-name";
    private static final String PASSWORD = "#password";
    private static final String LOGIN_BUTTON = "#login-button";

    public LoginPage(Page page) {
        super(page);
    }

    public InventoryPage login(String username, String password) {

        type(USERNAME, username);

        type(PASSWORD, password);

        click(LOGIN_BUTTON);

        return new InventoryPage(page);
    }

}