package com.kanchansali.pages;
import org.apache.logging.log4j.Logger;
import com.kanchansali.utils.LoggerUtil;

import com.kanchansali.config.ConfigReader;
import com.kanchansali.constants.LoginPageLocators;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    private static final Logger logger =
            LoggerUtil.getLogger(LoginPage.class);



    public LoginPage(Page page) {
        super(page);
    }

    public void open() {

        logger.info("Opening Login Page");

        page.navigate(ConfigReader.get("base.url"));
    }

    public InventoryPage login(String username, String password) {

        logger.info("Entering username");

        type(LoginPageLocators.USERNAME, username);

        logger.info("Entering password");

        type(LoginPageLocators.PASSWORD, password);

        logger.info("Clicking Login button");

        click(LoginPageLocators.LOGIN_BUTTON);

        logger.info("Login request submitted");

        return new InventoryPage(page);
    }

    public String getErrorMessage() {

        return locator(LoginPageLocators.ERROR_MESSAGE).textContent();

    }

    public boolean isErrorDisplayed() {

        return locator(LoginPageLocators.ERROR_MESSAGE).isVisible();

    }
}