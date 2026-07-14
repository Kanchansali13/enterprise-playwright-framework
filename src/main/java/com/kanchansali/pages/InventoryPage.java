package com.kanchansali.pages;

import com.kanchansali.constants.InventoryPageLocators;
import com.microsoft.playwright.Page;

public class InventoryPage extends BasePage {

    public InventoryPage(Page page) {

        super(page);

    }

    public boolean isInventoryDisplayed() {

        return locator(InventoryPageLocators.PAGE_TITLE)
                .textContent()
                .equals("Products");

    }

    public int getProductCount() {

        return locator(InventoryPageLocators.INVENTORY_ITEMS).count();

    }

    public void addProduct(String productName) {

        String locator = String.format(
                "//div[text()='%s']/ancestor::div[@class='inventory_item']//button",
                productName);

        click(locator);

    }

    public int getCartCount() {

        if(locator(InventoryPageLocators.CART_BADGE).count()==0)

            return 0;

        String cartCount = locator(InventoryPageLocators.CART_BADGE).textContent();
        return Integer.parseInt(cartCount.trim());

    }

    public CartPage openCart() {

        click(InventoryPageLocators.CART_BUTTON);

        return new CartPage(page);

    }

}