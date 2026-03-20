package com.globant.automation.tests;

import com.globant.automation.pages.CartPage;
import com.globant.automation.pages.InventoryPage;
import com.globant.automation.pages.LoginPage;
import com.globant.automation.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveProductTest extends BaseTest {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @BeforeMethod
    public void setup(){
        loginPage = new LoginPage(driver);

        inventoryPage = loginPage.login(username, password);
    }

    @Test(testName = "Verify remove products from shopping cart")
    public void removeProductsFlowTest(){
        Assert.assertEquals(inventoryPage.inventoryPage(), "Products");

        inventoryPage.addFirstThreeProductsToCart();

        CartPage cartPage = inventoryPage.goCart();

        Assert.assertEquals(cartPage.cartPage(), "Your Cart");
        Assert.assertEquals(cartPage.cartItemsCount(), 3);

        cartPage.removeProducts();

        Assert.assertTrue(cartPage.isCartEmpty(), "The cart should be empty after removing all products.");
    }
}