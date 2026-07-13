package com.kanchansali.pages;

import com.microsoft.playwright.Page;

public class InventoryPage extends BasePage {

    public InventoryPage(Page page) {

        super(page);

    }

    public boolean isInventoryDisplayed() {

        return page.url().contains("inventory");

    }

}