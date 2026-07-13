package com.kanchansali.pages;

import com.kanchansali.constants.CartPageLocators;
import com.microsoft.playwright.Page;

public class CartPage extends BasePage {

    public CartPage(Page page) {
        super(page);
    }

    /**
     * Returns total number of products present in cart
     */
    public int getCartItemCount() {

        return locator(CartPageLocators.CART_ITEMS).count();
    }

    /**
     * Verifies whether a product is present in cart
     */
    public boolean isProductPresent(String productName) {

        String productLocator = String.format(
                "//div[@class='inventory_item_name' and text()='%s']",
                productName);

        return locator(productLocator).isVisible();
    }

    /**
     * Removes a specific product from cart
     */
    public void removeProduct(String productName) {

        String removeButton = String.format(
                "//div[text()='%s']/ancestor::div[@class='cart_item']//button",
                productName);

        click(removeButton);
    }

    /**
     * Clicks Checkout button
     */
    public CheckoutPage checkout() {

        click(CartPageLocators.CHECKOUT_BUTTON);

        return new CheckoutPage(page);
    }

    /**
     * Continue Shopping
     */
    public InventoryPage continueShopping() {

        click(CartPageLocators.CONTINUE_SHOPPING_BUTTON);

        return new InventoryPage(page);
    }
}