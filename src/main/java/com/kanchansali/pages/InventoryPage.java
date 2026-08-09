package com.kanchansali.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class InventoryPage {

    private final Page page;

    public InventoryPage(Page page) {
        this.page = page;
    }

    // Verify Inventory page is displayed
    public boolean isInventoryDisplayed() {
        return page.locator(".title")
                .isVisible();
    }

    // Get page title
    public String getPageTitle() {
        return page.locator(".title")
                .innerText();
    }

    // Get number of products
    public int getProductCount() {
        return page.locator(".inventory_item")
                .count();
    }

    // Add product to cart
    public void addProduct(String productName) {

        page.locator(".inventory_item")
                .filter(new Locator.FilterOptions()
                        .setHasText(productName))
                .locator("button")
                .click();
    }

    // Keep this method too for compatibility with our earlier test
    public void addProductToCart(String productName) {
        addProduct(productName);
    }

    // Get cart item count
    public int getCartItemCount() {

        String count =
                page.locator(".shopping_cart_badge")
                        .innerText();

        return Integer.parseInt(count);
    }

    // Open cart and return CartPage
    public CartPage openCart() {

        page.locator(".shopping_cart_link")
                .click();

        return new CartPage(page);
    }
}